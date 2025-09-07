package br.com.movieflix.Mapper;

import br.com.movieflix.Controller.Request.CategoryRequest;
import br.com.movieflix.Controller.response.CategoryResponse;
import br.com.movieflix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();

    }
    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}

