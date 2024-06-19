package pe.edu.vallegrande.AS221S5_T05.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class LoanDto {
    private Long id;
    private Long user;
    private Long book;
    private int amount;
    private Date loanDate;
    private Date returnDate;

}
