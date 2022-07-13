import java.io.Serializable;

public class BeanTest implements Serializable {
    public static void main(String[] args) {
//        Album name = new Album();
//        name.setName("new Album");
//        name.setArtist("Bob");
//        name.setGenre("Smooth Jazz");
//        name.setSales(2000);
//        System.out.println(name.getName());



        Author bobSmith = new Author(1,"Bob", "Smith");
        Author janeSmith = new Author(2, "Jane", "Smith");

        Quote quote1 = new Quote(1, bobSmith, "quote");

        System.out.println("quote1 = " + quote1.getAuthor().getFirst_name());


    }

}
