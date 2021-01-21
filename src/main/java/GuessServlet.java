import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/guessing-app/guess.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        int guess = Integer.parseInt(req.getParameter("number"));

        if(guess == 2){
            res.sendRedirect("/correct");
        } else if(guess == 1 || guess == 3){
            res.sendRedirect("/wrong");
        } else {
            req.setAttribute("notValid", true);
            req.getRequestDispatcher("/guessing-app/guess.jsp").forward(req,res);
            res.sendRedirect("/guess");
        }

    }
}
