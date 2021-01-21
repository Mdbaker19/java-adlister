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

        int guess = Integer.parseInt(req.getParameter("inputNumber"));
        boolean valid = false;

//        int low = Integer.parseInt(req.getParameter("low"));
//        System.out.println(low);



        if(guess > 3 || guess < 1){
            valid = true;
        }

        if (guess == 2) {
            res.sendRedirect("/correct");
        } else if (guess == 1 || guess == 3) {
            res.sendRedirect("/wrong");
        } else {
            req.setAttribute("notValid", valid);
            req.getRequestDispatcher("/guessing-app/guess.jsp").forward(req, res);
            res.sendRedirect("/guess");
        }


    }
}
