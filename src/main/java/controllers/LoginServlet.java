package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("mattdb") && password.equals("password");
        boolean otherValidAttempt = username.equals("mandyab") && password.equals("otherpassword");
        HttpSession session = request.getSession();

        if (validAttempt) {
            session.setAttribute("user", username);
            session.setAttribute("userId", 1);
            response.sendRedirect("/profile");
        } else if(otherValidAttempt){
            session.setAttribute("user", username);
            session.setAttribute("userId", 2);
            response.sendRedirect("/profile");
        } else{
            response.sendRedirect("/login");
        }
    }
}
