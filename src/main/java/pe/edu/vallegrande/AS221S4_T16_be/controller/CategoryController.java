package pe.edu.vallegrande.AS221S4_T16_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Category;
import pe.edu.vallegrande.AS221S4_T16_be.service.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories/active")
    public List<Category> getActive(){
        return categoryService.getActive();
    }

    @GetMapping("/categories/inactive")
    public List<Category> getInactive(){
        return categoryService.getInactive();
    }

    @GetMapping("/category/{id}")
    public Category getForId(@PathVariable Long id){
        return categoryService.getForId(id);
    }

    @PostMapping("/category/")
    public Category created(@RequestBody Category category){
        return categoryService.created(category);
    }

    @PutMapping("/category/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category){
        return categoryService.update(id, category);
    }

    @Transactional
    @DeleteMapping("/category/removed/{id}")
    public void removed(@PathVariable Long id){
        categoryService.removed(id);
    }
    
    @Transactional
    @DeleteMapping("/category/restore/{id}")
    public void restore(@PathVariable Long id){
        categoryService.restore(id);
    }

    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}
