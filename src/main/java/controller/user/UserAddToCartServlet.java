package controller.user;

import factory.service.ItemServiceFactory;
import factory.service.ShoppingCartServiceFactory;
import model.Item;
import model.ShoppingCart;
import model.User;
import service.ItemService;
import service.ShoppingCartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/buy")
public class UserAddToCartServlet extends HttpServlet {

    private static final ItemService itemService = ItemServiceFactory.getItemService();
    private static final ShoppingCartService shoppingCartService =
            ShoppingCartServiceFactory.getShoppingCartService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        shoppingCartService.createShoppingCart(user);
        Long itemId = Long.valueOf(req.getParameter("id"));
        Item itemToAdd = itemService.getItem(itemId);
        shoppingCartService.addItem(user, itemToAdd);
        req.setAttribute("count", shoppingCartService.getSize());
        req.getRequestDispatcher("/user/items").forward(req, resp);
    }
}