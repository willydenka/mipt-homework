package com.project.library;

import com.project.library.scriptDB.Script;
import com.project.library.services.BookHolderService;
import com.project.library.services.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class LibraryApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(LibraryApplication.class, args);
		Script.fillDB(applicationContext.getBean(BookService.class),
				applicationContext.getBean(BookHolderService.class));
	}
}
