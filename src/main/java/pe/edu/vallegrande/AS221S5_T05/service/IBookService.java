package pe.edu.vallegrande.AS221S5_T05.service;

import pe.edu.vallegrande.AS221S5_T05.model.dto.BookDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getActive();
    List<Book> getInactive();
    Book getForId(Long id);
    BookDto created(BookDto bookDto);
    BookDto update(Long id, BookDto bookDto);
    void removed(Long id);
    void restore(Long id);
    void delete(Long id);
}
