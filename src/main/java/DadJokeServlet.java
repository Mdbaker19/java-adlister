import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "DadJokeServlet", urlPatterns = "/joke")
public class DadJokeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String query = req.getParameter("name");

        if(query == null) query = "Hungry";

        out.println("<h1>I will tell a joke</h1>");
        out.printf("<h1>here it is, Hi %s, I'm Dad</h1>", query);

    }
}
