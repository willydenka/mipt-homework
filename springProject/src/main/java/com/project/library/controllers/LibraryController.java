package com.project.library.controllers;

import com.project.library.dao.Book;
import com.project.library.dao.BookHolder;
import com.project.library.dto.BookDTO;
import com.project.library.dto.BookHolderDTO;
import com.project.library.services.BookHolderService;
import com.project.library.services.BookService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/library")
public class LibraryController {
    private BookService bookService;
    private BookHolderService bookHolderService;

    @Autowired
    public LibraryController(BookService bookService, BookHolderService bookHolderService) {
        this.bookService = bookService;
        this.bookHolderService = bookHolderService;
    }

    /*
    * Начальная страница приложения.
     */
    @GetMapping
    public String startPage() {
        return "startPage.html";
    }

    /*
    * Страница со списком книг.
     */
    @GetMapping("/books")
    public String booksPage(Model model) {
        List<Book> list = bookService.getAllBooks();
        model.addAttribute("books", list);
        return "booksPage.html";
    }

    /*
    * Страница со списком держателей книг.
     */
    @GetMapping("/bookHolders")
    public String bookHoldersPage(Model model) {
        List<BookHolder> bookHolders = bookHolderService.getAllBookHolders();
        model.addAttribute("bookHolders", bookHolders);
        return "bookHoldersPage.html";
    }

    /*
    * Страница конкретной книги.
     */
    @GetMapping("/books/{id}")
    public String book(@PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null)
            return "redirect:/library/books";
        if (book.getBookHolder() == null) {
            List<BookHolder> bookHolders = bookHolderService.getAllBookHolders();
            model.addAttribute("bookHolders", bookHolders);
        }
        model.addAttribute("book", book);
        return "book.html";
    }

    /*
    * Открепить книгу от держателя.
     */
    @PostMapping("/books/{id}")
    public String detachBook(@PathVariable int id) {
        bookService.detachBookFromHolder(id);
        return "redirect:/library/books/" + id;
    }

    /*
    * Страница конкретного держателя.
     */
    @GetMapping("/bookHolders/{id}")
    public String bookHolder(@PathVariable int id, Model model) {
        BookHolder bookHolder = bookHolderService.getBookHolderById(id);
        if (bookHolder == null)
            return "redirect:/library/bookHolders";
        model.addAttribute("bookHolder", bookHolder);
        return "bookHolder.html";
    }

    /*
    * Закрепить книгу за держателем.
     */
    @PostMapping("/books/assign")
    public String assign(@RequestParam int bookHolderId, @RequestParam int bookId) {
        BookHolder bookHolder = bookHolderService.getBookHolderById(bookHolderId);
        Book book = bookService.getBookById(bookId);
        bookHolder.addBook(book);
        bookHolderService.saveBookHolder(bookHolder);
        return "redirect:/library/books/" + bookId;
    }

    /*
    * Форма регистрации держателя.
     */
    @GetMapping("/registrationHolder")
    public String registrationPageHolder(Model model) {
        model.addAttribute("bookHolderDTO", new BookHolderDTO());
        return "createBookHolder.html";
    }

    /*
    * Форма регистрации книги.
     */
    @GetMapping("/registrationBook")
    public String registrationPageBook(Model model) {
        model.addAttribute("bookDTO", new BookDTO());
        return "createBook.html";
    }

    /*
    * Метод, позволяющий обратиться к rest-контроллеру этого же приложения.
    * Написан в целях практики.
     */
    @PostMapping("/regHolder")
    public String regHolder(@ModelAttribute BookHolderDTO bookHolderDTO) {
        System.out.println(
                bookHolderService.sendToRest("/regHolder", bookHolderDTO, BookHolder.class).getStatusCode());
        return "redirect:/library/bookHolders";
    }


    /*
     * Метод, позволяющий обратиться к rest-контроллеру этого же приложения.
     * Написан в целях практики.
     */
    @PostMapping("/regBook")
    public String regBook(@ModelAttribute @Valid BookDTO bookDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createBook.html";
        }
        System.out.println(bookService.sendToRest("/regBook", bookDTO, Book.class).getStatusCode());
        return "redirect:/library/books";
    }

    /*
    * Метод удаляет держателя.
     */
    @PostMapping("/removeHolder/{id}")
    public String removeHolder(@PathVariable int id) {
        bookHolderService.deleteById(id);
        return "redirect:/library/bookHolders";
    }
    /*
     * Метод удаляет книгу.
     */
    @PostMapping("/removeBook/{id}")
    public String removeBook(@PathVariable int id) {
        bookService.deleteById(id);
        return "redirect:/library/books";
    }

}
