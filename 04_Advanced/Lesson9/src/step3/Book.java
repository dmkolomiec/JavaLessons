package step3;

import java.time.LocalDate;
import java.util.function.Function;

@FunctionalInterface
interface GetBookAttrib {
    String get(Book book);
}

public class Book {
    public static boolean useLambda;
    public final int pages;
    public final int printingYear;
    public final int editionSize;
    private final String name;
    private final String author;

    public Book(String name, String author, int pages, int printingYear, int editionSize) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.printingYear = printingYear;
        this.editionSize = editionSize;
    }

    public String getDescriptionLambda(Function<Book, String> atr1, Function<Book, String> atr2, Function<Book, String> atr3) {
        return "Це " + atr1.apply(this) + " " + atr2.apply(this) + " та " + atr3.apply(this) + " книга.";
    }

    @SuppressWarnings("Convert2Lambda")
    public String getDescription() {
        if (useLambda) {
            return getDescriptionLambda(
                    book -> {
                        int age = LocalDate.now().getYear() - book.printingYear;
                        return age < 3 ? "зовсім нова" : (age < 8 ? "відносно нова" : "стара");
                    },
                    book -> (book.editionSize > 100_000 ? "дуже " : (book.editionSize > 50_000 ? "досить" : "не дуже")) + " популярна",
                    book -> book.pages > 500 ? "дуже об'ємна" : "невелика");

        } else {

            GetBookAttrib isNewBook = new GetBookAttrib() {
                @Override
                public String get(Book book) {
                    int age = LocalDate.now().getYear() - book.printingYear;
                    return age < 3 ? "зовсім нова" : (age < 8 ? "відносно нова" : "стара");
                }
            };

            GetBookAttrib isPopularBook = new GetBookAttrib() {
                @Override
                public String get(Book book) {
                    return (book.editionSize > 100_000 ? "дуже" : (book.editionSize > 50_000 ? "досить" : "не дуже")) + " популярна";
                }
            };

            GetBookAttrib isManyPages = new GetBookAttrib() {
                @Override
                public String get(Book book) {
                    return book.pages > 500 ? "дуже об'ємна" : "невелика";
                }
            };
            return "Це " + isNewBook.get(this) + " " + isPopularBook.get(this) + " та " + isManyPages.get(this) + " книга.";
        }
    }

    @Override
    public String toString() {
        return author + ". " + name + ". " + getDescription();
    }
}