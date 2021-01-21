import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewColorServlet", urlPatterns = "/viewcolor")
public class ViewColorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//        handles a request from pick color POST form so doPost method

        String color = req.getParameter("color");

        req.setAttribute("yourColorChoice", color);
        req.getRequestDispatcher("/color-app/viewcolor.jsp").forward(req,res);

    }
}
