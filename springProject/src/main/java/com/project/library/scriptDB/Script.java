package com.project.library.scriptDB;

import com.project.library.dao.Book;
import com.project.library.dao.BookHolder;
import com.project.library.services.BookHolderService;
import com.project.library.services.BookService;

import java.time.LocalDate;

public class Script {
    public static void fillDB(BookService bookService, BookHolderService bookHolderService) {
        Book a = new Book("Война и мир", "Лев Николаевич Толстой", 1869);
        Book b = new Book("Сияние", "Стивен Кинг", 1977);
        Book c = new Book("Темный рыцарь", "Грэг Кокс", 2008);
        Book d = new Book("Алиса в стране чудес", "Льюис Кэрролл", 1865);
        Book e = new Book("Мастер и Маргарита", "Михаил Афанасьевич Булгаков", 1940);
        BookHolder bha = new BookHolder("Петр", "Петров", "Сергеевич",
                LocalDate.of(1999, 5, 25));
        BookHolder bhb = new BookHolder("Иван", "Иванов", "Александрович",
                LocalDate.of(1987, 1, 5));
        BookHolder bhc = new BookHolder("Сидоров", "Константин", "Сергеевич",
                LocalDate.of(1989, 3, 17));
        BookHolder bhd = new BookHolder("Скворцов", "Алексей", "Иванович",
                LocalDate.of(1975, 6, 15));
        bookService.saveBook(a);
        bookService.saveBook(b);
        bookService.saveBook(c);
        bookService.saveBook(d);
        bookService.saveBook(e);
        bookHolderService.saveBookHolder(bha);
        bookHolderService.saveBookHolder(bhb);
        bookHolderService.saveBookHolder(bhc);
        bookHolderService.saveBookHolder(bhd);
    }
}
