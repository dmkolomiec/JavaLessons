package lesson6.entity;

import jakarta.persistence.*;

@Entity
@Table(indexes = {@Index(name = "author_idx1", columnList = "name")})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Author(long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author() {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + lastName;
    }
}
