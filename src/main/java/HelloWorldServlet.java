import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        String name = request.getParameter("name");
        if (name == null) {
            name = "User";
        }

        PrintWriter out = response.getWriter();
        // resp.getWriter().println("<h1>Contact Us</h1>"); This is an example of having it print out line by line
        response.setContentType("text/html");
        //This is to add multiple lines at once
        String html = "<h1>Hello, World!</h1>";
        html += "<h1>Hello, Again!</h1>";
        html += "<h2> Hello, " + name + "</h2>";

        //add a link to the contact us page
        html += "<a href='/contact-us'>Contact Us</a>";
        out.println(html);
    }
}
