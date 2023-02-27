package ru.agafonov.spring.data.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.agafonov.spring.data.library.models.Person;
import ru.agafonov.spring.data.library.services.BookService;
import ru.agafonov.spring.data.library.services.PersonService;

import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;
    private final BookService bookService;

    public PersonController(PersonService personService, BookService bookService) {
        this.personService = personService;
        this.bookService = bookService;
    }

    //
    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personService.findAll());

        return "person/index";
    }
    //
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){

        return "person/new";
    }
    //
    @PostMapping("/new")
    public String create(@ModelAttribute("person") @Valid Person person){
        personService.save(person);

        return "redirect:/person";
    }

    //
    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id){
        /*Person person = new Person();
        person = personService.findById(id);
        person.setBooks(bookService.findByOwner_Id(id));*/

        model.addAttribute("person", personService.findById(id).addBooks(bookService.findByOwner_Id(id)));
        model.addAttribute("books", bookService.findByOwner_Id(id));

        return "person/show";
    }
    //
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         @PathVariable("id") int id){

        personService.update(id, person);
        return "redirect:/person";
    }
    //
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personService.delete(id);

        return "redirect:/person";
    }

    //
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){

        model.addAttribute("person", personService.findById(id));
        return "person/edit";
    }
}
