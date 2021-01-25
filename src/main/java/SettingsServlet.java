import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SettingsServlet", urlPatterns = "/settings")
public class SettingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        HttpSession session = req.getSession();
        boolean alreadyLoggedIn = false;

        try{
            alreadyLoggedIn = (boolean) session.getAttribute("isLoggedIn");
        }catch (Exception ignored){}

        req.setAttribute("isLoggedIn", alreadyLoggedIn);
        req.getRequestDispatcher("/WEB-INF/settings.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        HttpSession session = req.getSession();

        if(req.getParameter("reset") != null){
            // reset value should be "yes" if they reset so this will run
            session.removeAttribute("font-color");
            session.removeAttribute("background-color");

            // these run from the other form post the reset one did not submit so its value is null so these will eval
        } else if(req.getParameter("theme").equals("dark")){
            session.setAttribute("font-color", "#fff");
            session.setAttribute("background-color", "#000");
        } else {
            session.setAttribute("font-color", "#000");
            session.setAttribute("background-color", "#fff");
        }

        res.sendRedirect("/settings");
    }

}
