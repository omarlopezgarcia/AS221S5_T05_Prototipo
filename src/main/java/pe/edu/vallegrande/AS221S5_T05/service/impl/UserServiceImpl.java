package pe.edu.vallegrande.AS221S5_T05.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S5_T05.model.dto.UserDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Rol;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Ubigeo;
import pe.edu.vallegrande.AS221S5_T05.model.entity.User;
import pe.edu.vallegrande.AS221S5_T05.repository.RolRepository;
import pe.edu.vallegrande.AS221S5_T05.repository.UbigeoRepository;
import pe.edu.vallegrande.AS221S5_T05.repository.UserRepository;
import pe.edu.vallegrande.AS221S5_T05.service.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UbigeoRepository ubigeoRepository;

    @Override
    public List<User> getActive() {
        return userRepository.findByActiveUser("A");
    }

    @Override
    public List<User> getInactive() {
        return userRepository.findByActiveUser("I");
    }

    @Override
    public User getForId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserDto created(UserDto userDto){
        Rol rol = rolRepository.findById(userDto.getRol()).get();
        Ubigeo ubigeo = ubigeoRepository.findById(userDto.getUbigeo()).get();
        User user = new User();
        user.setNames(userDto.getNames());
        user.setLastName(userDto.getLastName());
        user.setDocumentType(userDto.getDocumentType());
        user.setDocumentNumber(userDto.getDocumentNumber());
        user.setRol(rol);
        user.setUbigeo(ubigeo);
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setPasswords(userDto.getPasswords());
        user.setCellPhone(userDto.getCellPhone());
        user.setBirthDate(userDto.getBirthDate());
        user = userRepository.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        Optional<User> userId = userRepository.findById(id);
        if (userId.isPresent()){
            Rol rol = rolRepository.findById(userDto.getRol()).get();
            Ubigeo ubigeo = ubigeoRepository.findById(userDto.getUbigeo()).get();
            User user = userId.get();
            user.setNames(userDto.getNames());
            user.setLastName(userDto.getLastName());
            user.setDocumentType(userDto.getDocumentType());
            user.setDocumentNumber(userDto.getDocumentNumber());
            user.setRol(rol);
            user.setUbigeo(ubigeo);
            user.setEmail(userDto.getEmail());
            user.setUserName(userDto.getUserName());
            user.setPasswords(userDto.getPasswords());
            user.setCellPhone(userDto.getCellPhone());
            user.setBirthDate(userDto.getBirthDate());
            user = userRepository.save(user);
            userDto.setId(user.getId());
            return userDto;
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void removed(Long id) {
        userRepository.removeById(id);
    }

    @Transactional
    @Override
    public void restore(Long id) {
        userRepository.restoreById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
