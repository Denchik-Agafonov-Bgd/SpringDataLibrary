package ru.agafonov.spring.data.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.agafonov.spring.data.library.models.Book;
import ru.agafonov.spring.data.library.models.Person;
import ru.agafonov.spring.data.library.services.BookService;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("books") Book book){
        return "person/index";
    }

    @PostMapping()
    public String create(@ModelAttribute("books") @Valid Book book, BindingResult bindingResult){
        return "person/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        return "person/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @ModelAttribute("person") Person person, @PathVariable("id") int id){
        return "person/index";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("books") @Valid Book book, BindingResult bindingResult, @PathVariable("id") int id){
        return "person/index";
    }

    @PatchMapping("/{id}/release")
    public String update(@PathVariable("id") int id){
        return "person/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        return "person/index";
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id, @ModelAttribute("person")Person person){
        return "person/index";
    }
}
