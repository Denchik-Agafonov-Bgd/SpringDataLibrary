package ru.agafonov.spring.data.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agafonov.spring.data.library.models.Person;
import ru.agafonov.spring.data.library.repositories.PersonRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional
    public void save(Person personToSave){
        personRepository.save(personToSave);
    }

    public Person findById(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);

        return foundPerson.orElse(null);
    }

    @Transactional
    public void update(int id, Person updatePerson) {
        updatePerson.setId(id);
        personRepository.save(updatePerson);
    }

    @Transactional
    public void delete(int id){
        personRepository.deleteById(id);
    }
}
