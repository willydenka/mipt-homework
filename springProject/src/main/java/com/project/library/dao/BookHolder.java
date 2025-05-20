package com.project.library.dao;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "holders")
public class BookHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @OneToMany(mappedBy = "bookHolder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public BookHolder() {}

    public BookHolder(String name, String surname, String patronymic, LocalDate birthdate) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void addBook(Book book) {
        books.add(book);
        book.setBookHolder(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setBookHolder(null);
    }

    @Override
    public String toString() {
        return "BookHolder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
