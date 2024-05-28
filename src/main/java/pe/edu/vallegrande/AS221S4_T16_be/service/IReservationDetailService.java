package pe.edu.vallegrande.AS221S4_T16_be.service;

import pe.edu.vallegrande.AS221S4_T16_be.model.entity.LoanDetail;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.ReservationDetail;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Ubigeo;

import java.util.List;

public interface IReservationDetailService {
	List<ReservationDetail> getAll();
    ReservationDetail getForId(Long id);
    List<ReservationDetail> getForIdReservation(Long id);
    void delete(Long id);
}
