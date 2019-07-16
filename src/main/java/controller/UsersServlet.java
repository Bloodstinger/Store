package controller;

import db.Storage;
import factory.service.UserServiceFactory;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(value = "/admin/users")
public class UsersServlet extends HttpServlet {

    private final UserService userService = UserServiceFactory.getUserService();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<User> allUsers = userService.getAll();
        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
              String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> optUser = Optional.ofNullable(userService.getUser(email));
        if (password.equals(userService.getUser(email).getPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("user", optUser.get());
            resp.sendRedirect("users.jsp");
        } else {
            req.setAttribute("email", email);
            req.setAttribute("isValid", "Username or password is not correct");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }
}
