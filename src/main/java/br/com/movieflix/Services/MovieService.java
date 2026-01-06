package br.com.movieflix.Services;



import br.com.movieflix.Repository.MovieRepository;
import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.entity.Streaming;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;


    public Movie save(Movie movie){

       movie.setCategories(findCategories(movie.getCategories()));
       movie.setStreamings(findStreamings(movie.getStreamings()));

        return movieRepository.save(movie);
    }

    public List<Movie> findAllMovies(){
      return movieRepository.findAll();

    }

    public List<Category> findCategories(List<Category> categories){

        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.findById(category.getId()).ifPresent(categoriesFound::add));

        return categoriesFound;



    }

    public List<Streaming> findStreamings(List<Streaming> streamings){

        List<Streaming> StreamingsFound = new ArrayList<>();
        streamings.forEach(streaming-> streamingService.findById(streaming.getId()).ifPresent(StreamingsFound::add));

        return StreamingsFound;



    }


    public Optional<Movie> findByIdMovie(Long id ){
        return movieRepository.findById(id);
    }

}
