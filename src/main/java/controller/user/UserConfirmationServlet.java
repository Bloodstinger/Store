package controller.user;

import utils.ConfirmCode;
import utils.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/confirmation")
public class UserConfirmationServlet extends HttpServlet {

    private String email;
    private String confirmCode;
    private String address;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        email = req.getParameter("email");
        confirmCode = ConfirmCode.code();
        address = req.getParameter("address");
        Double totalPrice = Double.valueOf(req.getParameter("totalPrice"));
        new Thread(() -> SendEmail.sendCode(email, confirmCode, totalPrice)).start();
        req.setAttribute("email", email);
        req.setAttribute("address", address);
        req.setAttribute("totalPrice", totalPrice);
        req.getRequestDispatcher("/user_confirmation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String confirmCodeInput = req.getParameter("code");
        req.setAttribute("email", email);
        req.setAttribute("address", address);
        if (confirmCode.equals(confirmCodeInput)) {
            req.setAttribute("success", "Code correct!");
            req.getRequestDispatcher("/user_confirmation.jsp").forward(req, resp);
        } else {
            req.setAttribute("success", "Invalid code. Try again");
            req.getRequestDispatcher("/user_confirmation.jsp").forward(req, resp);
        }
    }
}
