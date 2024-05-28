package pe.edu.vallegrande.AS221S4_T16_be.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Country;
import pe.edu.vallegrande.AS221S4_T16_be.repository.CountryRepository;
import pe.edu.vallegrande.AS221S4_T16_be.service.ICountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getForId(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country created(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country update(Long id, Country countries) {
        Optional<Country> countryId = countryRepository.findById(id);
        if(countryId.isPresent()){
            Country country = countryId.get();
            country.setNames(countries.getNames());
            country.setCode(countries.getCode());
            return countryRepository.save(country);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}
