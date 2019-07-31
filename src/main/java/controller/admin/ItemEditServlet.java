package controller.admin;

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

    private static final ItemService itemService = ItemServiceFactory.getItemService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Item item = itemService.getItem(id);
        req.setAttribute("id", id);
        req.setAttribute("name", item.getName());
        req.setAttribute("description", item.getDescription());
        req.setAttribute("price", item.getPrice());
        req.getRequestDispatcher("/itemEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        Item itemToUpdate = itemService.getItem(id);
        itemToUpdate.setName(name);
        itemToUpdate.setDescription(description);
        itemToUpdate.setPrice(price);
        itemService.update(itemToUpdate);
        resp.sendRedirect("/admin/items");
    }
}
