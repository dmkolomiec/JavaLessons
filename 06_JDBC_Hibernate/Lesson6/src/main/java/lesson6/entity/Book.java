package lesson6.entity;

import jakarta.persistence.*;

@Entity
@Table(indexes = {@Index(name = "book_idx1", columnList = "name")})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    public Book() {}

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return id + ". " + name + " ("+ author.getId() + ". " + author.getName() + " " + author.getLastName() + ")";
    }
}