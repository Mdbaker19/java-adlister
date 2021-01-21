import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GuessRightServlet", urlPatterns = "/correct")
public class GuessRightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String message = "correct";

        req.setAttribute("outcome", message);

        req.getRequestDispatcher("/guessing-app/outcome.jsp").forward(req,res);

    }
}
