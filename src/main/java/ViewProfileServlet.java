import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("user");
//        String password = (String) request.getSession().getAttribute("password");
//
        if (username != null) {
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        } else {
           request.getRequestDispatcher("/login").forward(request, response);
        }
    }
}
