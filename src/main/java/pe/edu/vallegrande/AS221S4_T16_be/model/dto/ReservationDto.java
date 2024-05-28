package pe.edu.vallegrande.AS221S4_T16_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReservationDto {
    private Long id;
    private Long user;
    private Long librarian;
    private List<ReservationDetailDto> reservationDetail;
}
