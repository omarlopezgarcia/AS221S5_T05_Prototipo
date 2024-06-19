package pe.edu.vallegrande.AS221S5_T05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Country;
import pe.edu.vallegrande.AS221S5_T05.service.ICountryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class    CountryController {

    @Autowired
    private ICountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/country/{id}")
    public Country getForId(@PathVariable Long id){
        return countryService.getForId(id);
    }

    @PostMapping("/country/")
    public Country created(@RequestBody Country country){
        return countryService.created(country);
    }

    @PutMapping("/country/{id}")
    public Country update(@PathVariable Long id, @RequestBody Country country){
        return countryService.update(id, country);
    }

    @DeleteMapping("/country/{id}")
    public void delete(@PathVariable Long id){
        countryService.delete(id);
    }
}
