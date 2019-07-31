package controller;

import factory.service.ItemServiceFactory;
import factory.service.UserServiceFactory;
import model.ShoppingCart;
import model.User;
import service.ItemService;
import service.ShoppingCartService;
import service.UserService;
import service.impl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getUserService();
    private static final ItemService itemService = ItemServiceFactory.getItemService();
    private static final ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> optUser = Optional.ofNullable(userService.getUserByEmail(email));
        if (optUser.isPresent() && optUser.get().getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", optUser.get());
            if (optUser.get().getRole().equals("admin")) {
                resp.sendRedirect("/admin/users");
            } else {
//                session.setAttribute("cart", new ShoppingCart(optUser.get()));
                req.setAttribute("count", shoppingCartService.getSize());
                req.getRequestDispatcher("/user/items").forward(req, resp);
            }
        } else {
            resp.sendRedirect("/index.jsp");
        }
    }

    @Override
    public void init() throws ServletException {
        userService.addUser("root@localhost", "root", "admin");
        userService.addUser("test@localhost", "test", "user");
        itemService.addItem("Knife", "Sharp one.", 15.5);
        itemService.addItem("Form", "Sharp as well.", 73.2);
    }
}
