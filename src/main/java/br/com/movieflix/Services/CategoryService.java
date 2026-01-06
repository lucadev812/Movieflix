package br.com.movieflix.Services;

import br.com.movieflix.Repository.CategoryRepository;
import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import jakarta.transaction.Transactional;
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

    // mostrar todas as categorias

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }


    //salvar categoria
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }


//procurar por id
    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

    // deletar categoria
    public void deleteCategoryById(Long id){
     categoryRepository.deleteById(id);
    }



    @Transactional
    public Optional<Category> updateCategory(Long categoryId, Category category){

        Optional<Category> categories = categoryRepository.findById(categoryId);

        if (categories.isPresent()){

            Category newCategory = categories.get();

            newCategory.setName(category.getName());

            return Optional.of(newCategory);


        }
        return Optional.empty();

    }




}
