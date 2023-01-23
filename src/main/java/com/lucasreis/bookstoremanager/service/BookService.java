package com.lucasreis.bookstoremanager.service;

import com.lucasreis.bookstoremanager.dto.BookDTO;
import com.lucasreis.bookstoremanager.dto.MessageResponseDTO;
import com.lucasreis.bookstoremanager.entity.Book;
import com.lucasreis.bookstoremanager.mapper.BookMapper;
import com.lucasreis.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {

        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();

    }
}
