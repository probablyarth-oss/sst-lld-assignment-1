import java.util.*;

public class Driver {
    public static long countBooksByAuthor(List<Book> books, String author) {
        return books.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author)).count();
    }

    public static void printAllAuthors(List<Book> books) {
        books.stream().map(Book::getAuthor).distinct().forEach(System.out::println);
    }

    public static void printBooksByAuthor(List<Book> books, String author) {
        books.stream()
             .filter(b -> b.getAuthor().equalsIgnoreCase(author))
             .map(Book::getTitle)
             .forEach(System.out::println);
    }

    public static void printBooksByRating(List<Book> books, double rating) {
        books.stream()
             .filter(b -> b.getUserRating() == rating)
             .forEach(Book::printDetails);
    }

    public static void printBooksAndPricesByAuthor(List<Book> books, String author) {
        books.stream()
             .filter(b -> b.getAuthor().equalsIgnoreCase(author))
             .forEach(b -> System.out.println(b.getTitle() + " - $" + b.getPrice()));
    }

    public static void main(String[] args) {
        List<Book> books = DatasetReader.readBooks("data.csv");

        System.out.println("Total books by George Orwell: " + countBooksByAuthor(books, "George Orwell"));
        System.out.println("\nAll Authors:");
        printAllAuthors(books);
        System.out.println("\nBooks by George Orwell:");
        printBooksByAuthor(books, "George Orwell");
        System.out.println("\nBooks with Rating 4.8:");
        printBooksByRating(books, 4.8);
        System.out.println("\nBooks and Prices by George Orwell:");
        printBooksAndPricesByAuthor(books, "George Orwell");
    }
}
