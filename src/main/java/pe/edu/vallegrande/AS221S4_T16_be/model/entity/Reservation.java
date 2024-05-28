package pe.edu.vallegrande.AS221S4_T16_be.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reservation")
@Data @AllArgsConstructor @NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dates")
    private LocalDate dates;

    @ManyToOne
    @JoinColumn(name = "student_or_teacher_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "librarian_user")
    private User librarian;

    @Column(name = "active")
    private String active = "A";

    @JsonManagedReference
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservationDetail> reservationDetail;
    
    @PrePersist
    public void prePersist() {
    	this.dates = LocalDate.now();
    }
}
