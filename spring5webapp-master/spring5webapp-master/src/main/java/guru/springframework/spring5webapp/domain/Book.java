package guru.springframework.spring5webapp.domain;
/**
 * Created by AndersonF on 16/05/2022
 */


import javax.persistence.*;
import java.util.Set;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    public Book() {
    }

    public Book(String title, String isbn, Set<Author> author) {
        this.title = title;
        this.isbn = isbn;
        this.authors = author;
    }

    public Book(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthor() {
        return authors;
    }

    public void setAuthor(Set<Author> author) {
        this.authors = author;
    }
}
