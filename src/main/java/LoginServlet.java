//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "LoginServlet", urlPatterns = "/login")
//public class LoginServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        // render a view of this jsp with the url of just /login not /login.jsp
//        req.getRequestDispatcher("/login.jsp").forward(req,res);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            if (username.equals("admin") && password.equals("password")) {
////                System.out.println("logged in");
//                response.sendRedirect("/profile");
//            } else {
////                request.getRequestDispatcher("/login.jsp").forward(request, response);
//                response.sendRedirect("/login?error=try-again");
//            }
//        }
//
//}

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}