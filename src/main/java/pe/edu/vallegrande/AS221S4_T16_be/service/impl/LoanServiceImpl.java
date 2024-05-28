package pe.edu.vallegrande.AS221S4_T16_be.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T16_be.model.dto.LoanDetailDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.dto.LoanDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Book;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Loan;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.LoanDetail;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.User;
import pe.edu.vallegrande.AS221S4_T16_be.repository.BookRepository;
import pe.edu.vallegrande.AS221S4_T16_be.repository.LoanDetailRepository;
import pe.edu.vallegrande.AS221S4_T16_be.repository.LoanRepository;
import pe.edu.vallegrande.AS221S4_T16_be.repository.UserRepository;
import pe.edu.vallegrande.AS221S4_T16_be.service.ILoanService;

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

    @Autowired
    private LoanDetailRepository loanDetailRepository;

    @Override
    public List<Loan> getBorrowed() {
        return loanRepository.findByActiveLoan("P");
    }

    @Override
    public List<Loan> getReturned() {
        return loanRepository.findByActiveLoan("D");
    }

    @Override
    public Loan getForId(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    @Override
    public LoanDto created(LoanDto loanDto) {
        User user = userRepository.findById(loanDto.getUser()).get();
        User librarian = userRepository.findById(loanDto.getLibrarian()).get();
        Loan loan = new Loan();
        loan.setReturnDate(loanDto.getReturnDate());
        loan.setUser(user);
        loan.setLibrarian(librarian);
        loan = loanRepository.save(loan);
        loanDto.setId(loan.getId());
        for (LoanDetailDto ld: loanDto.getLoanDetail()){
            Book book = bookRepository.findById(ld.getBook()).get();
            LoanDetail loanDetail = new LoanDetail();
            loanDetail.setAmount(ld.getAmount());
            loanDetail.setBook(book);
            loanDetail.setLoan(loan);
            loanDetail = loanDetailRepository.save(loanDetail);
            ld.setId(loanDetail.getId());
        }
        return loanDto;
    }

    @Override
    public LoanDto update(Long id, LoanDto loanDto) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();
            User user = userRepository.findById(loanDto.getUser()).orElse(null);
            User librarian = userRepository.findById(loanDto.getLibrarian()).orElse(null);

            if (user != null && librarian != null) {
                loan.setReturnDate(loanDto.getReturnDate());
                loan.setUser(user);
                loan.setLibrarian(librarian);
                loan = loanRepository.save(loan);
                loanDto.setId(loan.getId());

                // Obtén los detalles de préstamo existentes
                List<LoanDetail> existingLoanDetails = loanDetailRepository.findByLoanId(loan.getId());

                // Itera sobre los detalles proporcionados en el DTO
                for (LoanDetailDto ld : loanDto.getLoanDetail()) {
                    Book book = bookRepository.findById(ld.getBook()).orElse(null);
                    if (book != null) {
                        // Verifica si el detalle de préstamo ya existe
                        Optional<LoanDetail> optionalExistingDetail = existingLoanDetails
                                .stream()
                                .filter(detail -> detail.getId().equals(ld.getId()))
                                .findFirst();

                        if (optionalExistingDetail.isPresent()) {
                            // Si existe, actualiza los campos
                            LoanDetail existingDetail = optionalExistingDetail.get();
                            existingDetail.setAmount(ld.getAmount());
                            existingDetail.setBook(book);
                            loanDetailRepository.save(existingDetail);
                        } else {
                            // Si no existe, crea uno nuevo
                            LoanDetail newDetail = new LoanDetail();
                            newDetail.setAmount(ld.getAmount());
                            newDetail.setBook(book);
                            newDetail.setLoan(loan);
                            loanDetailRepository.save(newDetail);
                        }
                    }
                }

                // Elimina los detalles que ya no están en el DTO
                existingLoanDetails
                        .stream()
                        .filter(detail -> !loanDto.getLoanDetail().stream().anyMatch(ld -> ld.getId().equals(detail.getId())))
                        .forEach(loanDetailRepository::delete);

                return loanDto;
            }
        }
        return null;
    }

    @Transactional
    @Override
    public void returned(Long id) {
        loanRepository.returnedForId(id);
    }

    @Transactional
    @Override
    public void borrowed(Long id) {
        loanRepository.borrowedForId(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        loanRepository.deleteById(id);
    }
}
