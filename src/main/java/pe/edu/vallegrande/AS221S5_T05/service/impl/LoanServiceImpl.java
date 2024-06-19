package pe.edu.vallegrande.AS221S5_T05.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S5_T05.model.dto.LoanDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Book;
import pe.edu.vallegrande.AS221S5_T05.model.entity.User;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Loan;
import pe.edu.vallegrande.AS221S5_T05.repository.BookRepository;
import pe.edu.vallegrande.AS221S5_T05.repository.UserRepository;
import pe.edu.vallegrande.AS221S5_T05.repository.LoanRepository;
import pe.edu.vallegrande.AS221S5_T05.service.ILoanService;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements ILoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Loan> getActive() {
        return loanRepository.findByActiveLoan("A");
    }

    @Override
    public List<Loan> getInactive() {
        return loanRepository.findByActiveLoan("I");
    }

    @Override
    public Loan getForId(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    public LoanDto created(LoanDto loanDto){
        User user = userRepository.findById(loanDto.getUser()).get();
        Book book = bookRepository.findById(loanDto.getBook()).get();
        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setAmount(loanDto.getAmount());
        loan.setLoanDate(loanDto.getLoanDate());
        loan.setReturnDate(loanDto.getReturnDate());

        loan = loanRepository.save(loan);
        loanDto.setId(loan.getId());
        return loanDto;
    }

    @Override
    public LoanDto update(Long id, LoanDto loanDto) {
        Optional<Loan> loanId = loanRepository.findById(id);
        if (loanId.isPresent()){
            User user = userRepository.findById(loanDto.getUser()).get();
            Book book = bookRepository.findById(loanDto.getBook()).get();
            Loan loan = loanId.get();
            loan.setUser(user);
            loan.setBook(book);
            loan.setAmount(loanDto.getAmount());
            loan.setLoanDate(loanDto.getLoanDate());
            loan.setReturnDate(loanDto.getReturnDate());
            loan = loanRepository.save(loan);
            loanDto.setId(loan.getId());
            return loanDto;
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void removed(Long id) {
        loanRepository.removeById(id);
    }

    @Transactional
    @Override
    public void restore(Long id) {
        loanRepository.restoreById(id);
    }

    @Override
    public void delete(Long id) {
        loanRepository.deleteById(id);
    }

}
