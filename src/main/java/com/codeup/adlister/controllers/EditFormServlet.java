package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editForm")
public class EditFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        HttpSession session = req.getSession();
        int currAd = Integer.parseInt(req.getParameter("editThisAd"));
        session.setAttribute("currentAd", currAd);
        req.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

    }
}
