import java.io.*;
import java.util.*;

public class DatasetReader {
    public static List<Book> readBooks(String fileName) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 7) {
                    Book book = new Book(
                            values[0].trim(),
                            values[1].trim(),
                            Double.parseDouble(values[2].trim()),
                            Integer.parseInt(values[3].trim()),
                            Double.parseDouble(values[4].trim()),
                            Integer.parseInt(values[5].trim()),
                            values[6].trim()
                    );
                    books.add(book);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading dataset: " + e.getMessage());
        }
        return books;
    }
}
