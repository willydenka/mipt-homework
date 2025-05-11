package com.project.library;

import com.project.library.dao.Book;
import com.project.library.dao.BookHandler;
import com.project.library.repositories.interfaces.BookHandlerRepository;
import com.project.library.repositories.interfaces.BookRepository;
import com.project.library.services.BookHandlerService;
import com.project.library.services.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryApplication {
    public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(LibraryApplication.class, args);

		BookService bookService = applicationContext.getBean(BookService.class);
		BookHandlerService bookHandlerService = applicationContext.getBean(BookHandlerService.class);
		BookHandlerRepository bookHandlerRepository = applicationContext.getBean(BookHandlerRepository.class);
		BookRepository bookRepository = applicationContext.getBean(BookRepository.class);

		Book b = new Book("Война и мир", "Лев Толстой", LocalDate.ofYearDay(1936, 26));
		bookService.saveBook(b);
		// Сохранил объект в БД books

		Book book = bookService.getBookById(1);
		System.out.println(book); // Вот он

		BookHandler bh = new BookHandler("Денис", "Лашин", "Александрович",
				LocalDate.of(2000, 11, 25));
		bookHandlerService.saveBookHandler(bh);
		// Сохранил объект в БД bookHandlers

		BookHandler bookHandler = bookHandlerService.getBookHandlerById(1);
		System.out.println(bookHandler); // Вот он


		// Тут теперь пробуем добавить хендлеру книгу
		 bookHandlerService.addBook(1, 1);
		// Почему-то не добавляется. Разобраться почему

		System.out.println("------------");
		System.out.println("В мейне: " + bookHandlerRepository.findById(1).get().getBooks());
		System.out.println("В мейне: " + bookRepository.findById(1).get().getBookHandler());
	}
}
