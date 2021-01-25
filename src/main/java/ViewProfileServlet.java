import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean isLoggedIn = false;
        String credential = null;

        try{
            isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
            credential = (String) session.getAttribute("user");
        } catch (Exception ignored){}


        if(credential == null){
            System.out.println("souting for if user value has not been set");
            response.sendRedirect("/login");
            return;
        }

        if(!isLoggedIn){
            System.out.println("you are not logged in and trying to visit the profile page, redirect to login page");
            response.sendRedirect("/login");
            return;
        }


        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
