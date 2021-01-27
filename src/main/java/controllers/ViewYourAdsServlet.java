package controllers;

import dao.DaoFactory;
import models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/yourAds")
public class ViewYourAdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // a method that can find the id based on the user name stored in the session
        // set a generic user name from  the 2 valid log ins right now to one of the 2 actually users in my db
        // get the id and then pass it into this by user method to display either un 1 or 2
        HttpSession session = req.getSession();
        String currentUserName = (String) session.getAttribute("user");
        int currUserId = DaoFactory.getAdsDao().findUserId(currentUserName);
        List<Ad> yourAds = DaoFactory.getAdsDao().byUser(currUserId);
        req.setAttribute("yourAds", yourAds);
        req.getRequestDispatcher("/WEB-INF/ads/yourAds.jsp").forward(req, res);
    }
}
