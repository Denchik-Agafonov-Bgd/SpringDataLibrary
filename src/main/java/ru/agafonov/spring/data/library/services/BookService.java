package ru.agafonov.spring.data.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agafonov.spring.data.library.models.Book;
import ru.agafonov.spring.data.library.models.Person;
import ru.agafonov.spring.data.library.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public void save(Book bookToSave) {
        bookRepository.save(bookToSave);
    }

    public Book findById(int id) {
        Optional<Book> foundBook = bookRepository.findById(id);

        return foundBook.orElse(null);
    }

    @Transactional
    public void update(Book bookToUpdate) {
        //bookToUpdate.setId(id);
        bookRepository.save(bookToUpdate);
    }

    @Transactional
    public void delete(int id){
        bookRepository.deleteById(id);
    }

    public List<Book> findByOwner_Id(int ownerId) {
        return bookRepository.findByOwner_Id(ownerId);
    }
}
