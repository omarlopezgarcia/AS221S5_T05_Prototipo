package pe.edu.vallegrande.AS221S4_T16_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.AS221S4_T16_be.model.dto.LoanDetailDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.dto.LoanDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Loan;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.LoanDetail;
import pe.edu.vallegrande.AS221S4_T16_be.service.ILoanDetailService;
import pe.edu.vallegrande.AS221S4_T16_be.service.ILoanService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
public class LoanController {

    @Autowired
    private ILoanService loanService;

    @Autowired
    private ILoanDetailService loanDetailService;

    @GetMapping("/loans/borrowed")
    public List<Loan> getBorrowed(){
        return loanService.getBorrowed();
    }

    @GetMapping("/loans/returned")
    public List<Loan> getReturned(){
        return loanService.getReturned();
    }

    @GetMapping("/loan/{id}")
    public Loan getForId(@PathVariable Long id){
        return loanService.getForId(id);
    }

    @GetMapping("/loanDetail/{id}")
    public List<LoanDetail> getForIdLoan(@PathVariable Long id){
        return loanDetailService.getForIdLoan(id);
    }

    @PostMapping("/loan/")
    public LoanDto created(@RequestBody LoanDto loanDto){
        return loanService.created(loanDto);
    }

    @PutMapping("/loan/{id}")
    public LoanDto update(@PathVariable Long id, @RequestBody LoanDto loanDto){
        return loanService.update(id, loanDto);
    }

    @DeleteMapping("/loan/returned/{id}")
    public void returned(@PathVariable Long id){
        loanService.returned(id);
    }

    @DeleteMapping("/loan/borrowed/{id}")
    public void borrowed(@PathVariable Long id){
        loanService.borrowed(id);
    }

    @DeleteMapping("/loan/{id}")
    public void delete(@PathVariable Long id){
        loanService.delete(id);
    }

    @DeleteMapping("/loanDetail/{id}")
    public void deleteDetail(@PathVariable Long id){
        loanDetailService.delete(id);
    }
}
