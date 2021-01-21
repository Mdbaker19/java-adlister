import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GuessLoginServlet", urlPatterns = "/guesslogin")
public class GuessLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/guessing-app/guessLogin.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int lowEnd = Integer.parseInt(req.getParameter("low"));
        int highEnd = Integer.parseInt(req.getParameter("high"));
        req.setAttribute("low", lowEnd);
        req.setAttribute("high", highEnd);


        String userName = req.getParameter("guesser");
        req.setAttribute("username", userName);
        req.getRequestDispatcher("/guessing-app/guess.jsp").forward(req,res);

    }
}
