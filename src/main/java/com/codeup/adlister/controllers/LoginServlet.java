package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

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
        HttpSession session = request.getSession();
        session.setAttribute("wrongLoginIfoUserName", false);
        session.setAttribute("wrongLoginPassword", false);
        session.setAttribute("attemptedUserName", username);

        boolean validAttempt = false;

        if(!password.equals(DaoFactory.getUsersDao().matchingPasswordForUN(username))) {
            session.setAttribute("wrongLoginPassword", true);
            response.sendRedirect("/login");
            return;
        }



        User currUser;

        try{
            currUser = DaoFactory.getUsersDao().findByUsername(username);
        } catch (Exception ignored){
            session.setAttribute("wrongLoginIfoUserName", true);
            response.sendRedirect("/login");
            return;
        }

        if(currUser != null){
            validAttempt = true;
        }

        if (validAttempt) {
            session.setAttribute("user", currUser);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
