package controller.user;

import factory.service.ItemServiceFactory;
import factory.service.ShoppingCartServiceFactory;
import model.Item;
import model.ShoppingCart;
import model.User;
import service.ItemService;
import service.ShoppingCartService;
import utils.PriceCount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/checkout")
public class UserCheckoutServlet extends HttpServlet {

    private static final ItemService itemService = ItemServiceFactory.getItemService();
    private static final ShoppingCartService shoppingService =
            ShoppingCartServiceFactory.getShoppingCartService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Item> itemsInCart = shoppingService.getAll();
        double totalPrice = PriceCount.getPrice(itemsInCart);
        req.setAttribute("allItems", itemsInCart);
        req.setAttribute("totalPrice", totalPrice);
        req.getRequestDispatcher("/user_checkout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Item> items = shoppingService.getAll();
        double totalPrice = PriceCount.getPrice(items);
        req.setAttribute("totalPrice", totalPrice);
        req.setAttribute("email", user.getEmail());
        req.getRequestDispatcher("/user_confirmation.jsp").forward(req, resp);
    }
}
