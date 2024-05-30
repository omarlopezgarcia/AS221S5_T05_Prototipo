package pe.edu.vallegrande.AS221S5_T05.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ubigeo")
@Data @NoArgsConstructor @AllArgsConstructor
public class Ubigeo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "district")
    private String district;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "department", nullable = false)
    private String department;
}
