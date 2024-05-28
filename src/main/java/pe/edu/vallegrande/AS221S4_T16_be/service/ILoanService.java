package pe.edu.vallegrande.AS221S4_T16_be.service;

import pe.edu.vallegrande.AS221S4_T16_be.model.dto.LoanDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Loan;

import java.util.List;

public interface ILoanService {
    List<Loan> getBorrowed();
    List<Loan> getReturned();
    Loan getForId(Long id);
    LoanDto created(LoanDto loanDto);
    LoanDto update(Long id, LoanDto loanDto);
    void returned(Long id);
    void borrowed(Long id);
    void delete(Long id);
}
