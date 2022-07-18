import java.util.List;

public interface Authors {
    List<Author> all();
    Author getAuthorById(long id);
    void insert(Author author);
}
