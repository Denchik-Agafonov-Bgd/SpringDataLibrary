package ru.agafonov.spring.data.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.agafonov.spring.data.library.models.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String ItemName);
}
