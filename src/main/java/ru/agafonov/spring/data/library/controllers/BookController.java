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
    //
    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", bookService.findAll());

        return "book/index";
    }
    //
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("book") Book book){
        return "book/new";
    }
    //
    @PostMapping("/new")
    public String create(@ModelAttribute("book") @Valid Book book){
        bookService.save(book);

        return "redirect:/book";
    }

    //
    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id){
        model.addAttribute("book", bookService.findById(id));

        return "book/show";
    }

    //
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, @PathVariable("id") int id){
        bookService.update(book, id);

        return "redirect:/book";
    }

    //
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookService.delete(id);

        return "redirect:/book";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book", bookService.findById(id));

        return "book/edit";
    }

    @PatchMapping("/{id}/release")
    public String update(@PathVariable("id") int id){
        return "person/index";
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id, @ModelAttribute("person")Person person){
        return "person/index";
    }
}
