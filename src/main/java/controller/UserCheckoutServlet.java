package controller;

import factory.service.ItemServiceFactory;
import factory.service.UserServiceFactory;
import model.Item;
import model.User;
import service.ItemService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.DoubleStream;

@WebServlet("/user/checkout")
public class UserCheckoutServlet extends HttpServlet {

    private final ItemService itemService = ItemServiceFactory.getItemService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> allItems = itemService.getAll();
        req.setAttribute("allItems", allItems);
        req.getRequestDispatcher("/user_checkout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Item> items = user.getShoppingCart().getAll();
        Double totalPrice = items
                .stream()
                .flatMapToDouble(x -> DoubleStream.of(x.getPrice()))
                .sum();
        req.setAttribute("totalPrice", totalPrice);
        req.setAttribute("email", user.getEmail());
        req.getRequestDispatcher("/user_confirmation.jsp").forward(req, resp);
    }
}
