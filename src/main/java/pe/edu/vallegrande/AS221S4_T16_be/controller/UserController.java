package pe.edu.vallegrande.AS221S4_T16_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.AS221S4_T16_be.model.dto.UserDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.User;
import pe.edu.vallegrande.AS221S4_T16_be.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users/active")
    public List<User> getActive(){
        return userService.getActive();
    }

    @GetMapping("/users/inactive")
    public List<User> getInactive(){
        return userService.getInactive();
    }

    @GetMapping("/user/{id}")
    public User getForId(@PathVariable Long id){
        return userService.getForId(id);
    }

    @PostMapping("/user/")
    public UserDto created(@RequestBody UserDto userDto){
        return userService.created(userDto);
    }

    @PutMapping("/user/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto userDto){
        return userService.update(id, userDto);
    }

    @DeleteMapping("/user/removed/{id}")
    public void removed(@PathVariable Long id){
        userService.removed(id);
    }

    @DeleteMapping("/user/restore/{id}")
    public void restore(@PathVariable Long id){
        userService.restore(id);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
