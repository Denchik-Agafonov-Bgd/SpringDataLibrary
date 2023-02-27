package ru.agafonov.spring.data.library.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][а-я]+ [А-Я][а-я]+", message = "Некорректное имя")
    @Column(name="name")
    private String name;

    /*@Min(value = 1900, message = "Дата рождения должна быть позже 1900 года")
    @Max(value = 2022, message = "Дата рождения должна быть раньше 2023 года")*/
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public Person(){}

    public Person(int id, String name, Date date_of_birth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = date_of_birth;
    }

    public Person(int id, String name, Date dateOfBirth, List<Book> books) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Person addBooks(List<Book> books) {
        setBooks(books);
        return this;
    }

    /*public void addBooks(Book book){
        if(this.books == null)
            this.books = new ArrayList<>();

        this.books.add(book);
        book.setOwner(this);
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_of_birth=" + dateOfBirth +
                '}';
    }
}
