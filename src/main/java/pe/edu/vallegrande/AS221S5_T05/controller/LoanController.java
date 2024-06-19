package pe.edu.vallegrande.AS221S5_T05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.AS221S5_T05.model.dto.LoanDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Loan;
import pe.edu.vallegrande.AS221S5_T05.service.ILoanService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class LoanController {

    @Autowired
    private ILoanService loanService;

    @GetMapping("/loans/active")
    public List<Loan> getActive(){
        return loanService.getActive();
    }

    @GetMapping("/loans/inactive")
    public List<Loan> getInactive(){
        return loanService.getInactive();
    }

    @GetMapping("/loan/{id}")
    public Loan getForId(@PathVariable Long id){
        return loanService.getForId(id);
    }

    @PostMapping("/loan/")
    public LoanDto created(@RequestBody LoanDto loanDto){
        return loanService.created(loanDto);
    }

    @PutMapping("/loan/{id}")
    public LoanDto update(@PathVariable Long id, @RequestBody LoanDto loanDto){return loanService.update(id, loanDto);}

    @DeleteMapping("/loan/removed/{id}")
    public void removed(@PathVariable Long id){
        loanService.removed(id);
    }

    @DeleteMapping("/loan/restore/{id}")
    public void restore(@PathVariable Long id){
        loanService.restore(id);
    }

    @DeleteMapping("/loan/{id}")
    public void delete(@PathVariable Long id){
        loanService.delete(id);
    }
}
