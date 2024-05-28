package pe.edu.vallegrande.AS221S4_T16_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Author;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Category;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private int stock;
    private String isbn;
    private Long category;
    private Long author;
}
