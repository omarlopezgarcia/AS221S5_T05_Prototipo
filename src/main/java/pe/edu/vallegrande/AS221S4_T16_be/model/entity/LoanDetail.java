package pe.edu.vallegrande.AS221S4_T16_be.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loan_detail")
@Data @AllArgsConstructor @NoArgsConstructor
public class LoanDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private int amount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
