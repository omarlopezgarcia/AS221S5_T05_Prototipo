package pe.edu.vallegrande.AS221S5_T05.service;

import pe.edu.vallegrande.AS221S5_T05.model.entity.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAll();
    Country getForId(Long id);
    Country created(Country country);
    Country update(Long id, Country country);
    void delete(Long id);
}
