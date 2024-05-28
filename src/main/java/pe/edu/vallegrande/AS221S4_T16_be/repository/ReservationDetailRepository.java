package pe.edu.vallegrande.AS221S4_T16_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.LoanDetail;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.ReservationDetail;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Ubigeo;

import java.util.List;

@Repository
public interface ReservationDetailRepository extends JpaRepository<ReservationDetail, Long> {
    @Query(value = "SELECT rd FROM ReservationDetail rd")
    List<ReservationDetail> findAll();
	
    @Query(value = "SELECT rd FROM ReservationDetail rd WHERE rd.reservation.id=?1")
    List<ReservationDetail> findByIdReservation(Long id);

    @Query("SELECT rd FROM ReservationDetail rd WHERE rd.reservation.id = :reservationId")
    List<ReservationDetail> findByReservationId(@Param("reservationId") Long reservationId);
}
