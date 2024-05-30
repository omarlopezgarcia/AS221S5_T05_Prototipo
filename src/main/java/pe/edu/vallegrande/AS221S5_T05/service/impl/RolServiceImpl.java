package pe.edu.vallegrande.AS221S5_T05.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Rol;
import pe.edu.vallegrande.AS221S5_T05.repository.RolRepository;
import pe.edu.vallegrande.AS221S5_T05.service.IRolService;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol getForId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public Rol created(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Long id, Rol roles) {
        Optional<Rol> rolId = rolRepository.findById(id);
        if (rolId.isPresent()){
            Rol rol = rolId.get();
            rol.setNames(roles.getNames());
            rol.setDescriptions(roles.getDescriptions());
            return rolRepository.save(rol);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        rolRepository.deleteById(id);
    }
}
