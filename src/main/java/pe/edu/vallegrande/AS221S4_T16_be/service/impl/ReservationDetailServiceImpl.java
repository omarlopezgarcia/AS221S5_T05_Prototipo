package pe.edu.vallegrande.AS221S4_T16_be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.ReservationDetail;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Ubigeo;
import pe.edu.vallegrande.AS221S4_T16_be.repository.BookRepository;
import pe.edu.vallegrande.AS221S4_T16_be.repository.ReservationDetailRepository;
import pe.edu.vallegrande.AS221S4_T16_be.service.IReservationDetailService;

import java.util.List;

@Service
public class ReservationDetailServiceImpl implements IReservationDetailService {

    @Autowired
    private ReservationDetailRepository reservationDetailRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<ReservationDetail> getAll() {
        return reservationDetailRepository.findAll();
    }

    @Override
    public ReservationDetail getForId(Long id) {
        return reservationDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReservationDetail> getForIdReservation(Long id) {
        return reservationDetailRepository.findByIdReservation(id);
    }

    @Override
    public void delete(Long id) {
        reservationDetailRepository.deleteById(id);
    }
}