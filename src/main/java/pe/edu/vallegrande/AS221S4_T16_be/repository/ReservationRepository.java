package pe.edu.vallegrande.AS221S4_T16_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Loan;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT r FROM Reservation r WHERE r.active=?1 ORDER BY r.id DESC")
    List<Reservation> findByActiveReservation(String active);

    @Modifying
    @Query("UPDATE Reservation r SET r.active='A' WHERE r.id=?1")
    void removedForId(Long id);

    @Modifying
    @Query("UPDATE Reservation r SET r.active='I' WHERE r.id=?1")
    void restoreForId(Long id);
}
