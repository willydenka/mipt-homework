package com.project.library.repositories.interfaces;

import com.project.library.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
/*
* Repository создают под каждую dao. Данная сущность позволяет выполнять действия над dao в отношении базы данных.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
