package pe.edu.vallegrande.AS221S4_T16_be.service;

import pe.edu.vallegrande.AS221S4_T16_be.model.dto.UserDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getActive();
    List<User> getInactive();
    User getForId(Long id);
    UserDto created(UserDto userDto);
    UserDto update(Long id, UserDto userDto);
    void removed(Long id);
    void restore(Long id);
    void delete(Long id);
}
