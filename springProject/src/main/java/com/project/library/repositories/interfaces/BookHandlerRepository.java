package com.project.library.repositories.interfaces;

import com.project.library.dao.BookHandler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookHandlerRepository extends JpaRepository<BookHandler, Integer> {
}
