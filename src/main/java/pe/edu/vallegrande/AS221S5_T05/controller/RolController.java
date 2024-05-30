package pe.edu.vallegrande.AS221S5_T05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Rol;
import pe.edu.vallegrande.AS221S5_T05.service.IRolService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/roles")
    public List<Rol> getAll(){
        return rolService.getAll();
    }

    @GetMapping("/rol")
    public Rol getForId(@PathVariable Long id){
        return rolService.getForId(id);
    }

    @PostMapping("/rol/")
    public Rol created(@RequestBody Rol rol){
        return rolService.created(rol);
    }

    @PutMapping("/rol/{id}")
    public Rol update(@PathVariable Long id, @RequestBody Rol rol){
        return rolService.update(id, rol);
    }

    @DeleteMapping("/rol/{id}")
    public void delete(@PathVariable Long id){
        rolService.delete(id);
    }

}
