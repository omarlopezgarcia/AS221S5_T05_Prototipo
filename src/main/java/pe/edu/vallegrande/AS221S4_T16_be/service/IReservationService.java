package pe.edu.vallegrande.AS221S4_T16_be.service;

import pe.edu.vallegrande.AS221S4_T16_be.model.dto.ReservationDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> getActive();
    List<Reservation> getInactive();
    Reservation getForId(Long id);
    ReservationDto created(ReservationDto reservationDto);
    ReservationDto update(Long id, ReservationDto reservationDto);
    void removed(Long id);
    void restore(Long id);
    void delete(Long id);
}
