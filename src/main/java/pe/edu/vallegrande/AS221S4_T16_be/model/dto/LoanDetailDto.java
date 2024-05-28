package pe.edu.vallegrande.AS221S4_T16_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class LoanDetailDto {
    private Long id;
    private int amount;
    private Long loan;
    private Long book;
}
