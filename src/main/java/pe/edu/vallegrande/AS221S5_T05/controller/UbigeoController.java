package pe.edu.vallegrande.AS221S5_T05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Ubigeo;
import pe.edu.vallegrande.AS221S5_T05.service.IUbigeoService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
public class UbigeoController {

    @Autowired
    private IUbigeoService ubigeoService;

    @GetMapping("/ubigeos")
    public List<Ubigeo> getAll(){
        return ubigeoService.getAll();
    }

    @GetMapping("/ubigeo/{id}")
    public Ubigeo getForId(@PathVariable Long id){
        return ubigeoService.getForId(id);
    }

    @PostMapping("/ubigeo/")
    public Ubigeo created(@RequestBody Ubigeo ubigeo){
        return ubigeoService.created(ubigeo);
    }

    @PutMapping("/ubigeo/{id}")
    public Ubigeo update(@PathVariable Long id, @RequestBody Ubigeo ubigeo){
        return ubigeoService.update(id, ubigeo);
    }

    @DeleteMapping("/ubigeo/{id}")
    public void delete(@PathVariable Long id){
        ubigeoService.delete(id);
    }
}
