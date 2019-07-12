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

@WebServlet(value = "/userEdit")
public class UserEditServlet extends HttpServlet {

    private final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("userEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("edit");
        User userToEdit = userService.getUser(Long.parseLong(id));
        String email = userToEdit.getEmail();
        req.setAttribute("email", email);
        req.getRequestDispatcher("/userEdit.jsp").forward(req, resp);
        //TODO: same as itemEdit
    }
}
