package pe.edu.vallegrande.AS221S4_T16_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Loan;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(value = "SELECT l FROM Loan l WHERE  l.active=?1 ORDER BY l.id DESC")
    List<Loan> findByActiveLoan(String active);

    @Modifying
    @Query("UPDATE Loan l SET l.active='D' WHERE l.id=?1")
    void returnedForId(Long id);

    @Modifying
    @Query("UPDATE Loan l SET l.active='P' WHERE l.id=?1")
    void borrowedForId(Long id);
}
