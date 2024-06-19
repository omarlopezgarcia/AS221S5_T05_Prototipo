package pe.edu.vallegrande.AS221S5_T05.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "loan")
@Data @NoArgsConstructor @AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "amount")
    private int amount;

    @DateTimeFormat(pattern = "dd/mm/aa")
    @Column(name = "loan_date")
    private Date loanDate;

    @DateTimeFormat(pattern = "dd/mm/aa")
    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "active")
    private String active = "A";
}
