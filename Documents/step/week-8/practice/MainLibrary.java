
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class LibraryItem {
    protected String title;
    protected static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate getDueDate();
}

class BookItem extends LibraryItem {
    public BookItem(String title) { super(title); }

    @Override
    public LocalDate getDueDate() {
        return CURRENT_DATE.plusDays(14); // 14 days
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title) { super(title); }

    @Override
    public LocalDate getDueDate() {
        return CURRENT_DATE.plusDays(7); // 7 days
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) { super(title); }

    @Override
    public LocalDate getDueDate() {
        return CURRENT_DATE.plusDays(3); // 3 days
    }
}

public class MainLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = Integer.parseInt(sc.nextLine().trim());
        LibraryItem[] items = new LibraryItem[n];

        // Regex pattern to extract ItemType and quoted ItemTitle
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"(.*)\"$");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String type = matcher.group(1);
                String title = matcher.group(2);

                switch (type) {
                    case "BOOK":
                        items[i] = new BookItem(title);
                        break;
                    case "DVD":
                        items[i] = new DVDItem(title);
                        break;
                    case "MAGAZINE":
                        items[i] = new MagazineItem(title);
                        break;
                }
            }
        }

        for (LibraryItem item : items) {
            if (item != null) {
                System.out.println(item.getTitle() + ": " + item.getDueDate());
            }
        }

        sc.close();
    }
}