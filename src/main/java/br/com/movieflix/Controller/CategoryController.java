package br.com.movieflix.Controller;

import br.com.movieflix.Services.CategoryService;
import br.com.movieflix.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

   private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategoryz(){
        return categoryService.findAll();
    }
    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id ){
        Optional<Category> optionalCategory = categoryService.findById(id);
        return optionalCategory.orElse(null);

    }

}
