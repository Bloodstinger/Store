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

@WebServlet(value = "/admin/itemEdit")
public class ItemEditServlet extends HttpServlet {

    private final ItemService itemService = ItemServiceFactory.getItemService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("id", id);
        req.setAttribute("name", itemService.getItem(id).getName());
        req.setAttribute("description", itemService.getItem(id).getDescription());
        req.setAttribute("price", itemService.getItem(id).getPrice());
        req.getRequestDispatcher("/itemEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        Item newItem = new Item(id, name, description, price);
        itemService.update(itemService.getItem(id), newItem);
        resp.sendRedirect("/admin/items");
    }
}
