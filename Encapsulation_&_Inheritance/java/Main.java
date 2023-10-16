import library.Library;
import media.Audiobook;
import media.Book;
import media.parent.Media;
import users.User;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("slava", "Egor", "fantastic", 500));
        library.addBook(new Audiobook("rus","Dimon", "drama", 200));
        library.addBook(new Audiobook("rus","Dimon", "drama", 200));
        Set<Media> mediaSet = library.getAllBooks();

        mediaSet.stream()
                .filter(media -> media.getName().equals("rus"))
                .findFirst()
                .ifPresent(library::removeBook);

        User user = new User();

        for (Media media: mediaSet)
            library.postBook(user, media);
        test(library, user);
        System.out.println("--------Возвращаем книги обратно----------");
        for (Media media: user.getMediaSet())
            library.getBook(user, media);
        test(library, user);
    }

    private static void test(Library library, User user) {
        for (Media media: user.getMediaSet())
            System.out.println(media.getName());
        System.out.println("------------------");
        for (Media media: library.viewListBorrowedBooks(user))
            System.out.println(media.getName());
        System.out.println("------------------");
        for (Media media: library.getAllBooks())
            System.out.println(media.getName());
    }
}
