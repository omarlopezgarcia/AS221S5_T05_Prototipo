package pe.edu.vallegrande.AS221S5_T05.service;

import pe.edu.vallegrande.AS221S5_T05.model.entity.Rol;

import java.util.List;

public interface IRolService {
    List<Rol> getAll();
    Rol getForId(Long id);
    Rol created(Rol rol);
    Rol update(Long id, Rol rol);
    void delete(Long id);
}
