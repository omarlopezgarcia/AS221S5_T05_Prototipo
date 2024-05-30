package pe.edu.vallegrande.AS221S5_T05.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "names", nullable = false)
    private String names;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "document_type", nullable = false)
    private String documentType;

    @Column(name = "document_number", nullable = false, unique = true)
    private String documentNumber;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "ubigeo_id", nullable = false)
    private Ubigeo ubigeo;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "user_name", nullable = false, unique = false)
    private String userName;

    @Column(name = "passwords", nullable = false)
    private String passwords;

    @Column(name = "cellphone", unique = true)
    private String cellPhone;

    @DateTimeFormat(pattern = "dd/mm/aa")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "active")
    private String active = "A";
}
