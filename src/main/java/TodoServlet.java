import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TodoServlet", urlPatterns = "/todo")
public class TodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.setAttribute("isAdmin", true);
        req.setAttribute("myItems", new String[] {"todo 1", "todo 2", "todo 3"});

        req.getRequestDispatcher("/todo.jsp").forward(req, res);
    }
}
