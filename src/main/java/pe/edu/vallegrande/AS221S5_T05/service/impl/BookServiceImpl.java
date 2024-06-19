package pe.edu.vallegrande.AS221S5_T05.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S5_T05.model.dto.BookDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Author;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Book;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Category;
import pe.edu.vallegrande.AS221S5_T05.repository.AuthorRepository;
import pe.edu.vallegrande.AS221S5_T05.repository.BookRepository;
import pe.edu.vallegrande.AS221S5_T05.repository.CategoryRepository;
import pe.edu.vallegrande.AS221S5_T05.service.IBookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Book> getActive() {
        return bookRepository.findByActiveBook("A");
    }

    @Override
    public List<Book> getInactive() {
        return bookRepository.findByActiveBook("I");
    }

    @Override
    public Book getForId(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public BookDto created(BookDto bookDto) {
        Category category = categoryRepository.findById(bookDto.getCategory()).get();
        Author author = authorRepository.findById(bookDto.getAuthor()).get();
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setStock(bookDto.getStock());
        book.setIsbn(bookDto.getIsbn());
        book.setCategory(category);
        book.setAuthor(author);
        book.setUrldownload(bookDto.getUrl_download());
        book.setDescription(bookDto.getDescription());
        book = bookRepository.save(book);
        bookDto.setId(book.getId());
        return bookDto;
    }

    @Override
    public BookDto update(Long id, BookDto bookDto) {
        Optional<Book> bookId = bookRepository.findById(id);
        if(bookId.isPresent()){
            Category category = categoryRepository.findById(bookDto.getCategory()).get();
            Author author = authorRepository.findById(bookDto.getAuthor()).get();
            Book book = bookId.get();
            book.setTitle(bookDto.getTitle());
            book.setStock(bookDto.getStock());
            book.setIsbn(bookDto.getIsbn());
            book.setCategory(category);
            book.setAuthor(author);
            book.setUrldownload(bookDto.getUrl_download());
            book.setDescription(bookDto.getDescription());
            book = bookRepository.save(book);
            bookDto.setId(book.getId());
            return bookDto;
        } else {
            return null;
        }
    }

    @Override
    public void removed(Long id) {
        bookRepository.removeById(id);
    }

    @Override
    public void restore(Long id) {
        bookRepository.restoreById(id);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
