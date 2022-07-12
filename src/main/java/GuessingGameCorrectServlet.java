
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/correct")
public class GuessingGameCorrectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String message ="You win!";

        req.setAttribute("message", message);

        RequestDispatcher view = req.getRequestDispatcher("/guess-result.jsp");
        view.forward(req,resp);
    }
}
