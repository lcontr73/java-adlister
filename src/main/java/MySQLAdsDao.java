import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao(Config config) { //constructor
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword()
            );
        } catch (SQLException sqle) {
            throw new RuntimeException("Error connecting to db", sqle);
        }
    }


    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM adlister_db.ads");
            while (rs.next()) {
                Ad ad = new Ad(rs.getInt("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description"));
                ads.add(ad);
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("Error connecting to db", sqle);
        }

        return ads;
    }

//    public static void main(String[] args) {
//        Ads adDao = new MySQLAdsDao(new Config());
//
//        List<Ad> ads = adDao.all();
//
//        for (Ad ad : ads) {
//            System.out.println(ad.getId());
//            System.out.println(ad.getUserId());
//            System.out.println(ad.getTitle());
//            System.out.println(ad.getDescription());
//        }
//    }

    @Override
    public Long insert(Ad ad) {

        long createdId = 0;
        String query = "INSERT INTO adlister_db.ads (user_id, title, description) VALUES ('" + ad.getUserId() + "', '" + ad.getTitle() + "', '" + ad.getDescription() + "')";
        try {

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            createdId = rs.getLong(1);
        } catch (SQLException sqle) {
            throw new RuntimeException("error connecting to db", sqle);
        }
return createdId;
    }

//    public static void main(String[] args) {
//        Ad ad = new Ad(1, "New ad", "something new");
//        System.out.println(ad.getTitle());
//        Ads adDao = new MySQLAdsDao(new Config());
//        adDao.insert(ad);
//    }
}
