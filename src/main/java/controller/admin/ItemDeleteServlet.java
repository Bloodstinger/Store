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

@WebServlet(value = "/admin/itemDelete")
public class ItemDeleteServlet extends HttpServlet {

    private static final ItemService itemService = ItemServiceFactory.getItemService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("delete");
        Item itemToRemove = itemService.getItem(Long.parseLong(id));
        itemService.removeItem(itemToRemove);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect("/admin/items");
    }
}
