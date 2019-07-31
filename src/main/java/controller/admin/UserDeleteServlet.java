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

@WebServlet(value = "/admin/userDelete")
public class UserDeleteServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("delete"));
        User userToDelete = userService.getUserById(id);
        userService.removeUser(userToDelete);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect("/admin/users");
    }
}
