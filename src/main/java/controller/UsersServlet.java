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

    private final UserService userService = UserServiceFactory.getUserService();

    private List<User> allUsers = userService.getAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean inDatabase = false;

        userService.addUser("root@localhost", "root");

        for (int i = 0; i < allUsers.size(); i++) {
            User user = allUsers.get(i);
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                inDatabase = true;
                break;
            }
        }
        if (inDatabase) {
            req.setAttribute("allUsers", allUsers);
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        } else {
            req.setAttribute("email", email);
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
