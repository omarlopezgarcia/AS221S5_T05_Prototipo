package pe.edu.vallegrande.AS221S5_T05.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private int stock;
    private String isbn;
    private Long category;
    private Long author;
    private String url_download;
    private String description;
}
