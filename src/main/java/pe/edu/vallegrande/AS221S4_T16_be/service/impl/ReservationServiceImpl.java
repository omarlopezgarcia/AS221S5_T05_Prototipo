package pe.edu.vallegrande.AS221S4_T16_be.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T16_be.model.dto.ReservationDetailDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.dto.ReservationDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Book;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Reservation;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.ReservationDetail;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.User;
import pe.edu.vallegrande.AS221S4_T16_be.repository.*;
import pe.edu.vallegrande.AS221S4_T16_be.service.IReservationService;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReservationDetailRepository reservationDetailRepository;

    @Override
    public List<Reservation> getActive() {
        return reservationRepository.findByActiveReservation("A");
    }

    @Override
    public List<Reservation> getInactive() {
        return reservationRepository.findByActiveReservation("I");
    }

    @Override
    public Reservation getForId(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public ReservationDto created(ReservationDto reservationDto) {
        User user = userRepository.findById(reservationDto.getUser()).get();
        User librarian = userRepository.findById(reservationDto.getLibrarian()).get();
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setLibrarian(librarian);
        reservation = reservationRepository.save(reservation);
        reservationDto.setId(reservation.getId());
        for (ReservationDetailDto rd : reservationDto.getReservationDetail()) {
            Book book = bookRepository.findById(rd.getBook()).get();
            ReservationDetail reservationDetail = new ReservationDetail();
            reservationDetail.setAmount(rd.getAmount());
            reservationDetail.setBook(book);
            reservationDetail.setReservation(reservation);
            reservationDetail = reservationDetailRepository.save(reservationDetail);
            rd.setId(reservationDetail.getId());
        }
        return reservationDto;
    }

    @Override
    public ReservationDto update(Long id, ReservationDto reservationDto) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            User user = userRepository.findById(reservationDto.getUser()).orElse(null);
            User librarian = userRepository.findById(reservationDto.getLibrarian()).orElse(null);
            if (user != null && librarian != null) {
                reservation.setUser(user);
                reservation.setLibrarian(librarian);
                reservation = reservationRepository.save(reservation);
                reservationDto.setId(reservation.getId());
                List<ReservationDetail> existingReservationDetails = reservationDetailRepository.findByReservationId(reservation.getId());
                for (ReservationDetailDto rd : reservationDto.getReservationDetail()) {
                    Book book = bookRepository.findById(rd.getBook()).orElse(null);
                    if (book != null) {
                        Optional<ReservationDetail> optionalExistingDetail = existingReservationDetails
                                .stream()
                                .filter(detail -> detail.getId().equals(rd.getId()))
                                .findFirst();
                        if (optionalExistingDetail.isPresent()) {
                            ReservationDetail existingDetail = optionalExistingDetail.get();
                            existingDetail.setAmount(rd.getAmount());
                            existingDetail.setBook(book);
                            reservationDetailRepository.save(existingDetail);
                        } else {
                            // If it doesn't exist, create a new one
                            ReservationDetail newDetail = new ReservationDetail();
                            newDetail.setAmount(rd.getAmount());
                            newDetail.setBook(book);
                            newDetail.setReservation(reservation);
                            reservationDetailRepository.save(newDetail);
                        }
                    }
                }

                // Remove details that are no longer in the DTO
                existingReservationDetails
                        .stream()
                        .filter(detail -> !reservationDto.getReservationDetail().stream()
                                .anyMatch(rd -> rd.getId().equals(detail.getId())))
                        .forEach(reservationDetailRepository::delete);

                return reservationDto;
            }
        }
        return null;
    }

    @Transactional
    @Override
    public void removed(Long id) {
        reservationRepository.removedForId(id);
    }

    @Transactional
    @Override
    public void restore(Long id) {
        reservationRepository.restoreForId(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}