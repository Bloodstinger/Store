package controller.user;

import factory.service.ItemServiceFactory;
import model.Item;
import model.ShoppingCart;
import model.User;
import service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/buy")
public class UserAddToCartServlet extends HttpServlet {

    private static final ItemService itemService = ItemServiceFactory.getItemService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute("cart");
        Long itemId = Long.valueOf(req.getParameter("id"));
        Item itemToAdd = itemService.getItem(itemId);
        shoppingCart.add(itemToAdd);
        req.setAttribute("count", shoppingCart.size());
        req.getRequestDispatcher("/user/items").forward(req, resp);
    }
}