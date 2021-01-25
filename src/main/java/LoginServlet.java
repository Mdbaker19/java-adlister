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
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = (username.equals("admin") || username.equals("user"))&& password.equals("password");

        HttpSession session = request.getSession();

        if (validAttempt) {

            if(username.equals("admin")){
                // admin path
                session.setAttribute("isAdmin", true);
                response.sendRedirect("/admin");
            } else {
                // normal user path
                session.setAttribute("isAdmin", false);
                response.sendRedirect("/profile");
            }

        } else{
            response.sendRedirect("/login");
        }
    }
}


/*
*                                                                      LOGIN
*                                                  ________________________________________________
*                                          Valid                                                              Invalid
*                          IsAdmin                             User                                              Redirect back to login
*                      To Admin Servlet                        To profile
*                      Set attribute isAdmin                isAdmin false
*                      Check for isAdmin                       ^^
*                  if so => to admin.jsp           else go back to ^^ profile.jsp^^
*
* */