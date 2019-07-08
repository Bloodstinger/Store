package controller;

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

@WebServlet(value = "/items")
public class ItemsServlet extends HttpServlet {

    private static ItemService itemService = ItemServiceFactory.getItemService();

    List<Item> allItems = itemService.getAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("allItems", allItems);
        req.getRequestDispatcher("/items.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("allItems", allItems);
        req.getRequestDispatcher("/items.jsp").forward(req, resp);
    }
}
