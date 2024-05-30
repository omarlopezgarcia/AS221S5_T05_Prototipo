package pe.edu.vallegrande.AS221S5_T05.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByActiveOrderByFullnameAsc(String active);

    @Modifying
    @Query("UPDATE Author u SET u.active='I' WHERE u.id=?1")
    void removeById(Long id);

    @Modifying
    @Query("UPDATE Author u SET u.active='A' WHERE u.id=?1")
    void restoreById(Long id);
}
