package pe.edu.vallegrande.AS221S5_T05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Loan;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(value = "SELECT l FROM Loan l WHERE l.active=?1 ORDER BY l.id DESC")
    List<Loan> findByActiveLoan(String active);

    @Modifying
    @Query("UPDATE Loan l SET l.active='I' WHERE l.id=?1")
    void removeById(Long id);

    @Modifying
    @Query("UPDATE Loan l SET l.active='A' WHERE l.id=?1")
    void restoreById(Long id);

}
