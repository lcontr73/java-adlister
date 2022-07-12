import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pizza-order") //URL pattern
public class PizzaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pizza.jsp").forward(req, resp); //jsp file that handles the request
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String crust = req.getParameter("crust");
        System.out.println(crust);

        String sauce = req.getParameter("sauce");
        System.out.println(sauce);

        String size = req.getParameter("size");
        System.out.println(size);

        String pepperoni = req.getParameter("pepperoni");
        if(pepperoni == null){
            System.out.println("no pepperoni");
        }
        System.out.println(pepperoni);


        String cheese = req.getParameter("cheese");
        if(cheese == null){

        }
        System.out.println(cheese);


        String veggie = req.getParameter("veggie");
        if(veggie == null){

        }
        System.out.println(veggie);


        String address = req.getParameter("address");
        System.out.println(address);


    }
}
