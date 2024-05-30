package pe.edu.vallegrande.AS221S5_T05.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.edu.vallegrande.AS221S5_T05.model.dto.AuthorDto;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Author;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Country;
import pe.edu.vallegrande.AS221S5_T05.repository.AuthorRepository;
import pe.edu.vallegrande.AS221S5_T05.repository.CountryRepository;
import pe.edu.vallegrande.AS221S5_T05.service.IAuthorService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Author> getActive() {
        return authorRepository.findByActiveOrderByFullnameAsc("A");
    }

    @Override
    public List<Author> getInactive() {
        return authorRepository.findByActiveOrderByFullnameAsc("I");
    }

    @Override
    public Author getForId(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public AuthorDto created(AuthorDto authorDto) {
        Country country = countryRepository.findById(authorDto.getCountry()).get();
        Author author = new Author();
        author.setFullname(authorDto.getFullname());
        author.setCountry(country);
        author = authorRepository.save(author);
        authorDto.setId(author.getId());
        return authorDto;
    }

    @Override
    public AuthorDto update(Long id, AuthorDto authorDto) {
        Optional<Author> authorId = authorRepository.findById(id);
        if (authorId.isPresent()) {
            Country country = countryRepository.findById(authorDto.getCountry()).get();
            Author author = authorId.get();
            author.setFullname(authorDto.getFullname());
            author.setCountry(country);
            author = authorRepository.save(author);
            authorDto.setId(author.getId());
            return authorDto;
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void removed(Long id) {
    	authorRepository.removeById(id);
    }

    @Transactional
    @Override
    public void restore(Long id) {
    	authorRepository.restoreById(id);
    }

    @Override
    public void delete(Long id) {
    	authorRepository.deleteById(id);
    }
}
