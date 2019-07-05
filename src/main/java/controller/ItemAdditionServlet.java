package controller;

import dao.DaoPattern;
import dao.ItemDAO;
import model.Item;
import service.ItemDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/items")
public class ItemAdditionServlet extends HttpServlet {
    private DaoPattern<Item> itemDao = ItemDaoFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("AddItem.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.valueOf(req.getParameter("price"));


        if (name.isEmpty() || description.isEmpty() || price < 0) {
            req.setAttribute("isEmpty", "All fields must be present and price must be greater than 0.");
            req.getServletContext().getRequestDispatcher("/AddItem.jsp").forward(req, resp);
        } else {
            Item item = ItemDAO.createItem(name, description, price);
            itemDao.add(item);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("/register");
        }

    }
}
