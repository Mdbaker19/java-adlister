package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        HttpSession session = req.getSession();
        int currAd = (int) session.getAttribute("currentAd");
        String newTitle = req.getParameter("newTitle");
        String newDescription = req.getParameter("newDesc");
        long currUserId = (long) session.getAttribute("userId");
        Ad newInfoAd = new Ad(
                currUserId,
                newTitle,
                newDescription
        );

        DaoFactory.getAdsDao().edit(currAd, newInfoAd);
        session.removeAttribute("currentAd");
        res.sendRedirect("/ads");
    }
}
