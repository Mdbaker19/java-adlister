import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomePageServlet", urlPatterns = "/home")
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.setAttribute("number", 1);
        req.setAttribute("title", "Home Page");
        req.setAttribute("isLoggedIn", true);

        req.getRequestDispatcher("/home.jsp").forward(req, res);
    }
}
