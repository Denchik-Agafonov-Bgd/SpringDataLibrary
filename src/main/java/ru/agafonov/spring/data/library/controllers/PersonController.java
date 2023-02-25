package ru.agafonov.spring.data.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.agafonov.spring.data.library.models.Book;
import ru.agafonov.spring.data.library.models.Person;
import ru.agafonov.spring.data.library.services.BookService;
import ru.agafonov.spring.data.library.services.PersonService;

import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;
    //private final BookService bookService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personService.findAll());

        return "person/index";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){

        return "person/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        return "person/new";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        return "person/new";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id){
        return "person/new";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,BindingResult bindingResult,
                         @PathVariable("id") int id){

        return "person/new";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        return "person/new";
    }
}
