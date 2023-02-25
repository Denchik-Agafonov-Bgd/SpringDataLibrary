package ru.agafonov.spring.data.library.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agafonov.spring.data.library.repositories.BookRepository;

@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
