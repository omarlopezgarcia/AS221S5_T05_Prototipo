package pe.edu.vallegrande.AS221S4_T16_be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T16_be.model.dto.LoanDetailDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.LoanDetail;
import pe.edu.vallegrande.AS221S4_T16_be.repository.BookRepository;
import pe.edu.vallegrande.AS221S4_T16_be.repository.LoanDetailRepository;
import pe.edu.vallegrande.AS221S4_T16_be.service.ILoanDetailService;

import java.util.List;

@Service
public class LoanDetailServiceImpl implements ILoanDetailService {

    @Autowired
    private LoanDetailRepository loanDetailRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public LoanDetail getForId(Long id) {
        return loanDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<LoanDetail> getForIdLoan(Long id) {
        return loanDetailRepository.findByIdLoan(id);
    }

    @Override
    public void delete(Long id) {
        loanDetailRepository.deleteById(id);
    }
}
