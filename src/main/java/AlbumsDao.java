import com.mysql.cj.jdbc.Driver;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumsDao implements Albums{
    private Connection connection;

    public AlbumsDao(){
        try{
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
        } catch (SQLException sqle){
            throw new RuntimeException("Error connecting to the db", sqle);
        }

    }

    @Override
    public List<Album> all() {

        List<Album> albums = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.albums");
            while (rs.next()){
                Album album = new Album(rs.getLong("id"), rs.getString("artist"), rs.getString("name"));
                albums.add(album);
            }
        } catch (SQLException sqle){
            throw new RuntimeException("error connecting to db", sqle);
        }
        return albums; //returns the list we created in the above method
    }

    @Override
    public void insert(Album album) {

    }
}
