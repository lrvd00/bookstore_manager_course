package com.lucasreis.bookstoremanager.repository;

import com.lucasreis.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
