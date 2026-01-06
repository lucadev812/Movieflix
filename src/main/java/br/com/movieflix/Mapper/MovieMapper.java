package br.com.movieflix.Mapper;

import br.com.movieflix.Controller.Request.MovieRequest;
import br.com.movieflix.Controller.Request.StreamingRequest;
import br.com.movieflix.Controller.response.CategoryResponse;
import br.com.movieflix.Controller.response.MovieResponse;
import br.com.movieflix.Controller.response.StreamingResponse;
import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.entity.Streaming;
import lombok.Builder;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request){

        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Movie.builder()
                .title(request.title())
                .rating(request.rating())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .categories(categories)
                .streamings(streamings)


                .build();

    }

    public static MovieResponse toMovieResponse(Movie movie){

        List<CategoryResponse> categoryResponses = movie.getCategories()
                .stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();


        List<StreamingResponse> streamingResponse = movie.getStreamings()
                .stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();


        return MovieResponse.builder()
                .id(movie.getId())
                .rating(movie.getRating())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .categories(categoryResponses)
                .streamings(streamingResponse)
                .build();
    }




}
