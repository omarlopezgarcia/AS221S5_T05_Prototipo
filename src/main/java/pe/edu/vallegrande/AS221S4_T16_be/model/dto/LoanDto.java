package pe.edu.vallegrande.AS221S4_T16_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class LoanDto {
    private Long id;
    private Date returnDate;
    private Long user;
    private Long librarian;
    private List<LoanDetailDto> loanDetail;
}
