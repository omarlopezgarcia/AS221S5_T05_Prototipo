package pe.edu.vallegrande.AS221S5_T05.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Category;
import pe.edu.vallegrande.AS221S5_T05.repository.CategoryRepository;
import pe.edu.vallegrande.AS221S5_T05.service.ICategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getActive() {
        return categoryRepository.findByActiveCategory("A");
    }

    @Override
    public List<Category> getInactive() {
        return categoryRepository.findByActiveCategory("I");
    }

    @Override
    public Category getForId(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category created(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category categories) {
        Optional<Category> categoryId = categoryRepository.findById(id);
        if(categoryId.isPresent()){
            Category category = categoryId.get();
            category.setNames(categories.getNames());
            return categoryRepository.save(category);
        } else {
            return null;
        }
    }

    @Override
    public void removed(Long id) {
        categoryRepository.removeById(id);
    }

    @Override
    public void restore(Long id) {
        categoryRepository.restoreById(id);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
