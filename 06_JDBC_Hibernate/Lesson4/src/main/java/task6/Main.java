package task6;
import task6.entity.Author;
import task6.entity.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AuthorHelper ah = new AuthorHelper();
        BookHelper bh = new BookHelper();

        Author gashek = new Author("Я́рослав Га́шек");
        long authorId = ah.addAuthor(gashek);

        if(authorId != 0) {
            bh.addBook(new Book("Моя торговля собаками", authorId));
            bh.addBook(new Book("Бравый солдат Швейк перед войной и другие удивительные истории", authorId));
            bh.addBook(new Book("Похождения бравого солдата Швейка", authorId));
        }

        List<Book> bookList = bh.getBookList();

        for (Book book : bookList) {
            System.out.println(book.getName() + "(" + ah.getAuthorById(book.getAuthor_id()).getName() + ")");
        }
    }

}
