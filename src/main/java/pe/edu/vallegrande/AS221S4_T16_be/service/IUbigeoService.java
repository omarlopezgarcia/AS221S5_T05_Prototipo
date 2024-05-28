package pe.edu.vallegrande.AS221S4_T16_be.service;

import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Ubigeo;

import java.util.List;

public interface IUbigeoService {
    List<Ubigeo> getAll();
    Ubigeo getForId(Long id);
    Ubigeo created(Ubigeo ubigeo);
    Ubigeo update(Long id, Ubigeo ubigeos);
    void delete(Long id);
}
