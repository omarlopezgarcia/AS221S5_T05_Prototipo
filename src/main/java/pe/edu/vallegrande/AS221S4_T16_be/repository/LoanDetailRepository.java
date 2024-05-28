package pe.edu.vallegrande.AS221S4_T16_be.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.LoanDetail;

import java.util.List;

@Repository
public interface LoanDetailRepository extends JpaRepository<LoanDetail, Long> {

    @Query(value = "SELECT ld FROM LoanDetail ld WHERE ld.loan.id=?1")
    List<LoanDetail> findByIdLoan(Long id);

    @Query("SELECT ld FROM LoanDetail ld WHERE ld.loan.id = :loanId")
    List<LoanDetail> findByLoanId(@Param("loanId") Long loanId);

}
