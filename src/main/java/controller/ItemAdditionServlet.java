package controller;

import factory.service.ItemServiceFactory;
import service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/additem")
public class ItemAdditionServlet extends HttpServlet {

    private static final double DEFAULT_PRICE = 1;

    private final ItemService itemService = ItemServiceFactory.getItemService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("additem.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String postPrice = req.getParameter("price");
        boolean hasID = !req.getParameter("id").isEmpty();
        double price = DEFAULT_PRICE;
        if (!postPrice.isEmpty()) {
            price = Double.parseDouble(postPrice);
        }
        if (name.isEmpty() || description.isEmpty() || price < 0) {
            req.setAttribute("isValid",
                    "All fields must be present and price must be greater than 0.");
            req.getServletContext().getRequestDispatcher("/additem.jsp").forward(req, resp);
        } else if (hasID) {
            Long id = Long.parseLong(req.getParameter("id"));
            itemService.update(id, name, description, price);
        } else {
            itemService.addItem(name, description, price);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("/additem");
        }
    }
}
