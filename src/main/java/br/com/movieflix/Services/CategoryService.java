package br.com.movieflix.Services;

import br.com.movieflix.Repository.CategoryRepository;
import br.com.movieflix.entity.Category;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

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

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }
}
