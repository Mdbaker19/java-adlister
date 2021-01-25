import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean alreadyLoggedIn = false;

        try {
            alreadyLoggedIn = (boolean) session.getAttribute("isLoggedIn");
            // this is being seen and ran when trying to log in
        } catch (Exception ignored){ }

        if(alreadyLoggedIn){
            System.out.println("should be redirecting to profile as you have logged in before in this session");
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username != null && password != null;
        HttpSession session = request.getSession();


        session.setAttribute("isLoggedIn", false);

        if (validAttempt) {
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
