import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuotesDao implements Quotes{
    private Connection connection;

//    public QuotesDao(){
//        try{
//            DriverManager.registerDriver(new Driver()); //generates potential exception
//            Config config = new Config();
//            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
//        } catch (SQLException sqle){
//            throw new RuntimeException("Error connecting to db", sqle);
//        }
//    }

    public QuotesDao(Config config){
        try{
            DriverManager.registerDriver(new Driver()); //generates potential exception
            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword()
            );
        } catch (SQLException sqle){
            throw new RuntimeException("Error connecting to db", sqle);
        }
    }


    @Override
    public List<Quote> all() {
        Authors authorsDao = DaoFactory.getAuthorsDao();
        List<Quote> quotes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.quotes");
            while (rs.next()) {
                long author_id = rs.getLong("author_id");//retrieving ID from quote table
                Author quoteAuthor = authorsDao.getAuthorById(author_id);//create author variable
                // Loop through Authors list for an id we retrieved from the quote table
               Quote quote = new Quote(
                        rs.getLong("id"),
                        rs.getString("content"),
                        quoteAuthor
                );
                quotes.add(quote);//this adds the quotes to the quote array to populate to the page
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("Error connecting to db", sqle);

        }
        return quotes;
    }
    @Override
    public void insert(Quote quote) {

    }
}
