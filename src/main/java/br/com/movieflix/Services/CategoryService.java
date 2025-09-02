package br.com.movieflix.Services;

import br.com.movieflix.Repository.CategoryRepository;
import br.com.movieflix.entity.Category;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;



    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
}
