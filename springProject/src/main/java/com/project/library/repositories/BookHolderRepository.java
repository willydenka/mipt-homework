package com.project.library.repositories;

import com.project.library.dao.BookHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookHolderRepository extends JpaRepository<BookHolder, Integer> {

    List<BookHolder> findAllByOrderByName();
}
