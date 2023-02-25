package ru.agafonov.spring.data.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.agafonov.spring.data.library.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
