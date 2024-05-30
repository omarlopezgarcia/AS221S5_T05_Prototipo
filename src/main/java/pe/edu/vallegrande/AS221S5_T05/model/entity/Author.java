package pe.edu.vallegrande.AS221S5_T05.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "author")
@Data @AllArgsConstructor @NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullname;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "active")
    private String active = "A";
}
