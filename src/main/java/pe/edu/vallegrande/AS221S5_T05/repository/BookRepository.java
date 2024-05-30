package pe.edu.vallegrande.AS221S5_T05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT b FROM Book b WHERE b.active=?1 ORDER BY b.title ASC")
    List<Book> findByActiveBook(String active);

    @Modifying
    @Query("UPDATE Book b SET b.active='I' WHERE b.id=?1")
    void removeById(Long id);

    @Modifying
    @Query("UPDATE Book b SET b.active='A' WHERE b.id=?1")
    void restoreById(Long id);

}
