package pe.edu.vallegrande.AS221S5_T05.service;

import pe.edu.vallegrande.AS221S5_T05.model.dto.UserDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.User;

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
