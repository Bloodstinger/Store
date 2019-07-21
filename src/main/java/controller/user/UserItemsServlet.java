package controller.user;

import factory.service.ItemServiceFactory;
import model.Item;
import service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/items")
public class UserItemsServlet extends HttpServlet {

    private static final ItemService itemService = ItemServiceFactory.getItemService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Item> allItems = itemService.getAll();
        req.setAttribute("allItems", allItems);
        req.getRequestDispatcher("/user_items.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Item> allItems = itemService.getAll();
        req.setAttribute("allItems", allItems);
        req.getRequestDispatcher("/user_items.jsp").forward(req, resp);
    }
}
