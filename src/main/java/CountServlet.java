import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {
    private int counter = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String count = req.getParameter("counter");

        if(count == null){
            counter++;
            count = String.valueOf(counter);
        } else {
            counter = Integer.parseInt(count);
        }

        String content = "<h1>Will display a counter here</h1>";
        content+="<p>Current Count : " + count + " </p>";
        content+="<a href='/hello'>Go back to main page</a>";


        out.println(content);

    }
}
