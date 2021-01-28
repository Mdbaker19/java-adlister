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
import java.util.Set;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        session.setAttribute("invalidUn", false);
        session.setAttribute("invalidEm", false);
        session.setAttribute("invalidPa", false);


        String newEm = request.getParameter("email");
        String newUN = request.getParameter("un");
        String newP = request.getParameter("pass");

        if(alreadyTaken(newUN)){
            session.setAttribute("userNameTakenAlready", true);
            response.sendRedirect("/register");
            return;
        }

        if(!validUN(newUN)){
            session.setAttribute("invalidUn", true);
            response.sendRedirect("/register");
            return;
        } else if(!validEmail(newEm)){
            session.setAttribute("invalidEm", true);
            response.sendRedirect("/register");
            return;
        } else if(!validPass(newP)){
            session.setAttribute("invalidPa", true);
            response.sendRedirect("/register");
            return;
        }

        User newUser = DaoFactory.getUsersDao().createUser(newEm, newUN, newP);
        DaoFactory.getUsersDao().insert(newUser);
        session.setAttribute("user", newUser);
        response.sendRedirect("/profile");


    }

    public static boolean validUN(String un){
        if(un.length() < 5) return false;
        return true;
    }

    public static boolean validPass(String pass){
        if(pass.length() < 8) return false;
        return true;
    }

    // possibly not needed as it is input type email
    public static boolean validEmail(String email){
        return (email.contains(".") && email.contains("@"));
    }

    public static boolean alreadyTaken(String un){
        Set<String> allCurrUn = DaoFactory.getUsersDao().allCurrUserNames();

        return allCurrUn.contains(un);
    }
}
