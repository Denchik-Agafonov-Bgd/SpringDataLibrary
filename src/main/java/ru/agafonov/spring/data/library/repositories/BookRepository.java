package ru.agafonov.spring.data.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.agafonov.spring.data.library.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByOwner_Id(int IdOwner);
}
