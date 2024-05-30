package pe.edu.vallegrande.AS221S5_T05.service;

import pe.edu.vallegrande.AS221S5_T05.model.entity.Ubigeo;

import java.util.List;

public interface IUbigeoService {
    List<Ubigeo> getAll();
    Ubigeo getForId(Long id);
    Ubigeo created(Ubigeo ubigeo);
    Ubigeo update(Long id, Ubigeo ubigeos);
    void delete(Long id);
}
