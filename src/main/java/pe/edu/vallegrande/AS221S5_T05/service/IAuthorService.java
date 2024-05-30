package pe.edu.vallegrande.AS221S5_T05.service;

import pe.edu.vallegrande.AS221S5_T05.model.dto.AuthorDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Author;

import java.util.List;

public interface IAuthorService {
	List<Author> getActive();
    List<Author> getInactive();
    Author getForId(Long id);
    AuthorDto created(AuthorDto authorDto);
    AuthorDto update(Long id, AuthorDto authorDto);
    void removed(Long id);
    void restore(Long id);
    void delete(Long id);
}
