import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizzaOrder")
public class PizzaOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        String crust = req.getParameter("crust");
        String sauce = req.getParameter("sauce");
        String size = req.getParameter("size");
        String toppings = req.getParameter("toppings");
        String address = req.getParameter("address");
        System.out.println(crust);
        System.out.println(sauce);
        System.out.println(size);
        System.out.println(address);
        System.out.println(toppings);

        req.getRequestDispatcher("/pizzaOrder.jsp").forward(req,res);

    }
}
