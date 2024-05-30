package pe.edu.vallegrande.AS221S5_T05.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Ubigeo;
import pe.edu.vallegrande.AS221S5_T05.repository.UbigeoRepository;
import pe.edu.vallegrande.AS221S5_T05.service.IUbigeoService;

import java.util.List;
import java.util.Optional;

@Service
public class UbigeoServiceImpl implements IUbigeoService {

    @Autowired
    private UbigeoRepository ubigeoRepository;

    @Override
    public List<Ubigeo> getAll() {
        return ubigeoRepository.findAllOrderByDistrictAsc();
    }

    @Override
    public Ubigeo getForId(Long id) {
        return ubigeoRepository.findById(id).orElse(null);
    }

    @Override
    public Ubigeo created(Ubigeo ubigeo) {
        return ubigeoRepository.save(ubigeo);
    }

    @Override
    public Ubigeo update(Long id, Ubigeo ubigeos) {
        Optional<Ubigeo> ubigeoId = ubigeoRepository.findById(id);
        if(ubigeoId.isPresent()){
            Ubigeo ubigeo = ubigeoId.get();
            ubigeo.setDistrict(ubigeos.getDistrict());
            ubigeo.setProvince(ubigeos.getProvince());
            ubigeo.setDepartment(ubigeos.getDepartment());
            return ubigeoRepository.save(ubigeo);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        ubigeoRepository.deleteById(id);
    }
}
