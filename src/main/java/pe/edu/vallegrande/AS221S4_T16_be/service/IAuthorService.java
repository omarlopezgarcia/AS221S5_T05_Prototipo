package pe.edu.vallegrande.AS221S4_T16_be.service;

import pe.edu.vallegrande.AS221S4_T16_be.model.dto.AuthorDto;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Author;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Ubigeo;

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
