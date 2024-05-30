package pe.edu.vallegrande.AS221S5_T05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT c FROM Category c WHERE c.active=?1 ORDER BY c.names ASC")
    List<Category> findByActiveCategory(String active);

    @Modifying
    @Query("UPDATE Category c SET c.active='I' WHERE c.id=?1")
    void removeById(Long id);

    @Modifying
    @Query("UPDATE Category c SET c.active='A' WHERE c.id=?1")
    void restoreById(Long id);
}
