package br.com.movieflix.Controller;

import br.com.movieflix.Services.CategoryService;
import br.com.movieflix.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

   private final CategoryService categoryService;


    @GetMapping()
    public List<Category> getAllCategoryz(){
        return categoryService.findAll();

    }
}
