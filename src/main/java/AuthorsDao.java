import com.mysql.cj.jdbc.Driver;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDao implements Authors {

    private Connection connection;

//    public AuthorsDao(){
//        try{
//            DriverManager.registerDriver(new Driver());
//            //Config object
//            Config config = new Config();
//            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
//
//        } catch (SQLException sqle) {
//            throw new RuntimeException("Error connecting to db", sqle);
//        }
//    }

    public AuthorsDao(Config config){
        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword()
            );
        } catch (SQLException sqle) {
            throw new RuntimeException("Error connecting to db", sqle);
        }
    }


    @Override
    public List<Author> all() {
        List<Author> authors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.authors");
            while (rs.next()){
                Author author = new Author(rs.getLong("id"), rs.getString("author_name"));
                authors.add(author);
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("Error connecting to db", sqle);
        }

        return authors;
    }

    //Implementing method created in Authors interface
    @Override
    public Author getAuthorById(long id) {
        Author author = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.authors WHERE id='" + id + "'");
            rs.next();
            author = new Author(rs.getLong("id"), rs.getString("author_name"));

        } catch (SQLException sqle) {
            throw new RuntimeException("Error connecting to db", sqle);
        }
        return author;
    }

    @Override
    public void insert(Author author) { //this passes an author object into insert
        String author_name = author.getAuthor_name();
        String query = "INSERT INTO codeup_test_db.authors (author_name) VALUES ('" + author_name + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            long key = rs.getLong(1);
            System.out.println("The key of the new insert is: " + key);
        } catch (SQLException sqle) {
            throw new RuntimeException("error connecting to db", sqle);
        }
    }


}
