import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html"); // the response we are sending to the user is text

        String query = req.getParameter("name");

        if(query == null) query = "World";
        // the equivalent of sout in console to display on page
        // used to write to the http response
        PrintWriter out = res.getWriter();

        String pageContent = "<h1>Hello World From Java!</h1>";
        pageContent+="<h3>Hello " + query + "</h3>";
        pageContent+="<a href='/count'>View Current Counter</a>";

        // send redirect to redirect to a different location

        // hard coded text
        out.println(pageContent);


    }
}


/*
*
* public class .... extends HttpServlet
* @Override and protected void ....
* add @WebServlet with required urlPattern
* write code in doGet for output of that urlPattern "/ ...something"
*
* redeploy with this new end point refresh button like the run button and do the redeploy radio button select
*
* */