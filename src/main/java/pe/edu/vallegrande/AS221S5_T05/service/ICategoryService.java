package pe.edu.vallegrande.AS221S5_T05.service;

import pe.edu.vallegrande.AS221S5_T05.model.entity.Category;

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
