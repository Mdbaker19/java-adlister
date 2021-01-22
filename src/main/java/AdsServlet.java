import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/ads")
public class AdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Ad> allAds = DaoFactory.getAdsDao().all();
        req.setAttribute("ads", allAds);
//        req.setAttribute("ads", DaoFactory.getAdsDao().all());
        req.getRequestDispatcher("/ads/index.jsp").forward(req, res);
    }
}