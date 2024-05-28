package pe.edu.vallegrande.AS221S4_T16_be.service;

import pe.edu.vallegrande.AS221S4_T16_be.model.dto.LoanDetailDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.LoanDetail;

import java.util.List;

public interface ILoanDetailService {
    LoanDetail getForId(Long id);
    List<LoanDetail> getForIdLoan(Long id);
    void delete(Long id);
}
