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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String confirmCode = ConfirmCode.code();
        String address = req.getParameter("address");
        Double totalPrice = Double.valueOf(req.getParameter("totalPrice"));
        new Thread(() -> SendEmail.sendCode(email, confirmCode, totalPrice)).start();
        req.setAttribute("email", email);
        req.setAttribute("address", address);
        req.setAttribute("totalPrice", totalPrice);
        req.getSession().setAttribute("code", confirmCode);
        req.getRequestDispatcher("/user_confirmation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String confirmCode = (String) req.getSession().getAttribute("code");
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
