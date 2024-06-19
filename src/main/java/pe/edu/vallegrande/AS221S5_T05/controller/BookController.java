package pe.edu.vallegrande.AS221S5_T05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import pe.edu.vallegrande.AS221S5_T05.model.dto.BookDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Book;
import pe.edu.vallegrande.AS221S5_T05.service.IBookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {


    @Autowired
    private IBookService bookService;

    @GetMapping("/books/active")
    public List<Book> getActive(){
        return bookService.getActive();
    }

    @GetMapping("/books/inactive")
    public List<Book> getInactive(){
        return bookService.getInactive();
    }

    @PostMapping("/book/")
    public BookDto created(@RequestBody BookDto bookDto){
        return bookService.created(bookDto);
    }

    @PutMapping("/book/{id}")
    public BookDto update(@PathVariable Long id, @RequestBody BookDto bookDto){
        return bookService.update(id, bookDto);
    }

    @Transactional
    @DeleteMapping("/book/removed/{id}")
    public void removed(@PathVariable Long id){
        bookService.removed(id);
    }

    @Transactional
    @DeleteMapping("/book/restore/{id}")
    public void restore(@PathVariable Long id){
        bookService.restore(id);
    }

    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }

}
