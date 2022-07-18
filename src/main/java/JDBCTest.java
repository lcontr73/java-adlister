import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    private static List<String> getAlbumNames(){
        List<String> albumNames = new ArrayList<>();
        try{
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());

            // Create statement object (tell the database what we want
            Statement statement = connection.createStatement();

            // Execute statement
            ResultSet rs = statement.executeQuery("SELECT name FROM codeup_test_db.albums");
            while (rs.next()){
                albumNames.add(rs.getString("name")); //This is the name of the column on columnLabel
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return albumNames;
    }

    public static void main(String[] args) {
        List<String> albumNames = getAlbumNames();
        for(String albumName: albumNames) {
            System.out.println(albumName);
        }
    }
}
