package pe.edu.vallegrande.AS221S4_T16_be.service;

import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Category;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Rol;

import java.util.List;

public interface ICategoryService {
    List<Category> getActive();
    List<Category> getInactive();
    Category getForId(Long id);
    Category created(Category category);
    Category update(Long id, Category categories);
    void removed(Long id);
    void restore(Long id);
    void delete(Long id);
}
