package pe.edu.vallegrande.AS221S4_T16_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserDto {
    private Long id;
    private String names;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private Long rol;
    private Long ubigeo;
    private String email;
    private String userName;
    private String passwords;
    private String cellPhone;
    private LocalDate birthDate;
}
