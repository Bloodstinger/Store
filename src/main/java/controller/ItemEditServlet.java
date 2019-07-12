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

@WebServlet(value = "/itemEdit")
public class ItemEditServlet extends HttpServlet {

    private final ItemService itemService = ItemServiceFactory.getItemService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("itemEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("edit");
        Item itemToEdit = itemService.getItem(Long.parseLong(id));
        req.setAttribute("name", itemToEdit.getName());
        req.setAttribute("description", itemToEdit.getDescription());
        req.setAttribute("price", String.valueOf(itemToEdit.getPrice()));
        req.setAttribute("id", id);
        req.getRequestDispatcher("/additem").forward(req, resp);
        //TODO: fix item addition. Item addition adds copy instead of editing.
    }
}
