package controller;

import factory.service.UserServiceFactory;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> optUser = Optional.ofNullable(userService.getUser(email));
        if (optUser.isPresent() && optUser.get().getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", optUser.get());
            if (optUser.get().getRole().equals("admin")) {
                resp.sendRedirect("/admin/users");
            } else {
                req.setAttribute("count", optUser.get().cartSize());
                req.getRequestDispatcher("/user/items").forward(req, resp);
            }
        } else {
            resp.sendRedirect("/index.jsp");
        }
    }
}
