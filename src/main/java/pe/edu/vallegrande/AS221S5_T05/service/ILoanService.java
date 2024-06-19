package pe.edu.vallegrande.AS221S5_T05.service;

import pe.edu.vallegrande.AS221S5_T05.model.dto.LoanDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Loan;

import java.util.List;

public interface ILoanService {
    List<Loan> getActive();
    List<Loan> getInactive();
    Loan getForId(Long id);
    LoanDto created(LoanDto loanDto);
    LoanDto update(Long id, LoanDto loanDto);
    void removed(Long id);
    void restore(Long id);
    void delete(Long id);
}
