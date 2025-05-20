package com.project.library.dao;
import jakarta.persistence.*;

/*
* dao (data access object) - применяется для проекции сущности в базе данных.
 */
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "authorName", length = 50)
    private String authorName;
    @Column(name = "year_of_production")
    private int yearOfProduction;
    @ManyToOne
    @JoinColumn(name = "holder_id")
    private BookHolder bookHolder;

    public Book() {}

    public Book(String title, String authorName, int yearOfProduction) {
        this.title = title;
        this.authorName = authorName;
        this.yearOfProduction = yearOfProduction;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public BookHolder getBookHolder() {
        return bookHolder;
    }

    public void setBookHolder(BookHolder bookHolder) {
        this.bookHolder = bookHolder;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
