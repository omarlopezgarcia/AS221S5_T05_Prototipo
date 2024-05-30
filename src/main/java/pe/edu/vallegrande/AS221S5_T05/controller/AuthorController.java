package pe.edu.vallegrande.AS221S5_T05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import pe.edu.vallegrande.AS221S5_T05.model.dto.AuthorDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Author;
import pe.edu.vallegrande.AS221S5_T05.service.IAuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping("/authors/active")
    public List<Author> getActive(){
        return authorService.getActive();
    }

    @GetMapping("/authors/inactive")
    public List<Author> getInactive(){
        return authorService.getInactive();
    }

    @GetMapping("/author/{id}")
    public Author getForId(@PathVariable Long id){
        return authorService.getForId(id);
    }

    @PostMapping("/author/")
    public AuthorDto created(@RequestBody AuthorDto authorDto){
        return authorService.created(authorDto);
    }

    @PutMapping("/author/{id}")
    public AuthorDto update(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        return authorService.update(id, authorDto);
    }

    @Transactional
    @DeleteMapping("/author/removed/{id}")
    public void removed(@PathVariable Long id){
    	authorService.removed(id);
    }
    
    @Transactional
    @DeleteMapping("/author/restore/{id}")
    public void restore(@PathVariable Long id){
    	authorService.restore(id);
    }

    @DeleteMapping("/author/{id}")
    public void delete(@PathVariable Long id){
    	authorService.delete(id);
    }
}
