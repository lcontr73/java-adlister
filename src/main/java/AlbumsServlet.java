import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="AlbumsServlet", urlPatterns = "/albums")
public class AlbumsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Creating the object of new AlbumsDao. a new object here will generate the database connection as well from the Dao
        Albums albumsDao = new AlbumsDao();
        //create list of albums
        List<Album> albums = albumsDao.all(); //retrieves list of albums
        //this will be able to hold our list of objects
        req.setAttribute("albums", albums);
        req.getRequestDispatcher("/WEB-INF/albums.jsp").forward(req, resp);
    }
}
