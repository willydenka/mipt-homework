package com.project.library.repositories;

import com.project.library.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/*
* Repository создают под каждую dao. Данная сущность позволяет выполнять действия над dao в отношении базы данных.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
    /*
    * Кастомный запрос, позволяющий сортировать в БД по названию.
     */
    List<Book> findAllByOrderByTitle();

}
