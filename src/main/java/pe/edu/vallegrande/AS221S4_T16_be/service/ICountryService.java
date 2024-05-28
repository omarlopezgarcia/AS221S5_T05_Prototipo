package pe.edu.vallegrande.AS221S4_T16_be.service;

import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Category;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAll();
    Country getForId(Long id);
    Country created(Country country);
    Country update(Long id, Country country);
    void delete(Long id);
}
