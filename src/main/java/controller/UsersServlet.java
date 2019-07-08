package controller;

import factory.service.UserServiceFactory;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/users")
public class UsersServlet extends HttpServlet {

    private static UserService userService = UserServiceFactory.getUserService();

    List<User> allUsers = userService.getAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
