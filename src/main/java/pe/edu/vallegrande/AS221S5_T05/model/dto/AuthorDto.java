package pe.edu.vallegrande.AS221S5_T05.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String fullname;
    private Long country;
}
