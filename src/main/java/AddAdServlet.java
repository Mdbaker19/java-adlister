import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddAdServlet", urlPatterns = "/newAd")
public class AddAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String title = request.getParameter("title");
        String desc = request.getParameter("description");
        long userId = Long.getLong(request.getParameter("userId"));
        long id = Long.getLong(request.getParameter("id"));

        Ad custom = new Ad(id, userId, title, desc);
        List<Ad> allAds = DaoFactory.getAdsDao().all();
        allAds.add(custom);

        for(Ad ad : allAds){
            System.out.println(ad.getTitle());
        }

        request.setAttribute("ads", allAds);
//        response.sendRedirect("/ads");
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);

    }
}
