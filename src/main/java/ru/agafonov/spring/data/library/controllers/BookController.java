package ru.agafonov.spring.data.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.agafonov.spring.data.library.models.Book;
import ru.agafonov.spring.data.library.models.Person;
import ru.agafonov.spring.data.library.services.BookService;
import ru.agafonov.spring.data.library.services.PersonService;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final PersonService personService;

    public BookController(BookService bookService, PersonService personService) {

        this.bookService = bookService;
        this.personService = personService;
    }

    //
    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", bookService.findAll());

        return "book/index";
    }

    //
    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "book/new";
    }

    //
    @PostMapping("/new")
    public String create(@ModelAttribute("book") Book book){
        bookService.save(book);

        return "redirect:/book";
    }

    //
    @GetMapping("/{id}")
    public String show(Model model, @ModelAttribute("person") Person person, @PathVariable("id") int id){
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("people", personService.findAll());

        return "book/show";
    }

    //
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") Book book){
        book.setOwner(bookService.findById(book.getId()).getOwner());

        bookService.update(book);

        return "redirect:/book";
    }

    //
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookService.delete(id);

        return "redirect:/book";
    }

    //
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book", bookService.findById(id));

        return "book/edit";
    }


    @PatchMapping("/{id}/deleteOwnerToBook")
    public String deleteOwnerToBook(@PathVariable("id") int id){
        Book updateBook = bookService.findById(id);
        updateBook.setOwner(null);

        bookService.update(updateBook);

        return "redirect:/book";
    }


    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id, @ModelAttribute("person")Person person){
        Book updateBook = bookService.findById(id);
        updateBook.setOwner(person);

        bookService.update(updateBook);

        return "redirect:/book/"+id;
    }
}
