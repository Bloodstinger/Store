package controller.admin;

import factory.service.UserServiceFactory;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin/userEdit")
public class UserEditServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("email", userService.getUser(id).getEmail());
        req.getRequestDispatcher("/userEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        User userToEdit = userService.getUser(id);
        String email = userToEdit.getEmail();
        String newEmail = req.getParameter("email");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");
        String role = req.getParameter("role");

        if (email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            req.setAttribute("isValid", "All fields could not be empty");
            req.setAttribute("checkEmail", email);
            req.getRequestDispatcher("/userEdit.jsp").forward(req, resp);
        } else {
            if (password.equals(repeatPassword)) {
                User newUser = new User(newEmail, password, role);
                userService.update(userToEdit, newUser);
                resp.sendRedirect("/admin/users");
            } else {
                req.setAttribute("email", email);
                req.setAttribute("isValid", "The password is not valid, try again");
                req.getRequestDispatcher("/userEdit.jsp").forward(req, resp);
            }
        }
    }
}
