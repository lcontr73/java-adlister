import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page-views")
public class PageViewCounterServlet extends HttpServlet {

    int pageViews = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reset = req.getParameter("reset");
        if(reset != null){
            pageViews = 0;
        }
        pageViews += 1;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>You have " + pageViews + " page views.</h1>");
    }
}
