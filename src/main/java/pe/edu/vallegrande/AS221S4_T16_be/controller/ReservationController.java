package pe.edu.vallegrande.AS221S4_T16_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.AS221S4_T16_be.model.dto.ReservationDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Reservation;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.ReservationDetail;
import pe.edu.vallegrande.AS221S4_T16_be.service.IReservationDetailService;
import pe.edu.vallegrande.AS221S4_T16_be.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IReservationDetailService reservationDetailService;

    @GetMapping("/reservationDetail/all")
    public List<ReservationDetail> getAll(){
        return reservationDetailService.getAll();
    }
    
    @GetMapping("/reservations/borrowed")
    public List<Reservation> getActive(){
        return reservationService.getActive();
    }

    @GetMapping("/reservations/returned")
    public List<Reservation> getInactive(){
        return reservationService.getInactive();
    }

    @GetMapping("/reservation/{id}")
    public Reservation getForId(@PathVariable Long id){
        return reservationService.getForId(id);
    }

    @GetMapping("/reservationDetail/{id}")
    public List<ReservationDetail> getForIdReservation(@PathVariable Long id){
        return reservationDetailService.getForIdReservation(id);
    }

    @PostMapping("/reservation/")
    public ReservationDto created(@RequestBody ReservationDto reservationDto){
        return reservationService.created(reservationDto);
    }

    @PutMapping("/reservation/{id}")
    public ReservationDto update(@PathVariable Long id, @RequestBody ReservationDto reservationDto){
        return reservationService.update(id, reservationDto);
    }

    @DeleteMapping("/reservation/returned/{id}")
    public void returned(@PathVariable Long id){
        reservationService.removed(id);
    }

    @DeleteMapping("/reservation/borrowed/{id}")
    public void borrowed(@PathVariable Long id){
        reservationService.restore(id);
    }

    @DeleteMapping("/reservation/{id}")
    public void delete(@PathVariable Long id){
        reservationService.delete(id);
    }

    @DeleteMapping("/reservationDetail/{id}")
    public void deleteDetail(@PathVariable Long id){
        reservationDetailService.delete(id);
    }
}
