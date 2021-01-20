import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//        String password = req.getParameter("pass");
//        String username = req.getParameter("user");
//
//        if(password.equals("password") && username.equals("admin")) {
//            res.sendRedirect("/login");
//        } else {
//            res.sendRedirect("/profile");
//        }

    }
}
