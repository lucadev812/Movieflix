package br.com.movieflix.Services;


import br.com.movieflix.Repository.MovieRepository;
import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.entity.Streaming;
import jakarta.transaction.Transactional;
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

// SALVAR FILME
    public Movie save(Movie movie){
       movie.setCategories(findCategories(movie.getCategories()));
       movie.setStreamings(findStreamings(movie.getStreamings()));

        return movieRepository.save(movie);
    }
    // PEGAR TODOS OS FILMES
    public List<Movie> findAllMovies(){
      return movieRepository.findAll();

    }

    // PROCURAR FILME POR ID
    public Optional<Movie> findByIdMovie(Long id ){
        return movieRepository.findById(id);
    }




    public List<Movie> findByCategory(Long categoryId){
        return movieRepository.findByCategories(List.of(Category.builder().id(categoryId).build()));

    }



    @Transactional
    public Optional<Movie> updateMovie(Long movieId, Movie movie){

        Optional<Movie> optionalMovie = movieRepository.findById(movieId);

        if (optionalMovie.isPresent()){


            List<Category> categories = findCategories(movie.getCategories());
            List<Streaming> streamings = findStreamings(movie.getStreamings());

            Movie movieSalvo = optionalMovie.get();
            movieSalvo.setTitle(movie.getTitle());
            movieSalvo.setDescription(movie.getDescription());
            movieSalvo.setRating(movie.getRating());
            movieSalvo.setReleaseDate(movie.getReleaseDate());

            movieSalvo.getCategories().clear();
            movieSalvo.getCategories().addAll(categories);
            movieSalvo.getStreamings().clear();
            movieSalvo.getStreamings().addAll(streamings);

          return   Optional.of(movieSalvo);
        }
        return Optional.empty();


    }

    public void deleteMovie(Long id){

        movieRepository.deleteById(id);

    }








    // METODO AUXILIAR PARA PEGAR CATEGORIAS COM O OUTROS ATRIBUTOS ALEM DO ID
    public List<Category> findCategories(List<Category> categories){
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.findById(category.getId()).ifPresent(categoriesFound::add));

        return categoriesFound;
    }

    // METODO AUXILIAR PARA PEGAR STREAMINGS COM O OUTROS ATRIBUTOS ALEM DO ID
    public List<Streaming> findStreamings(List<Streaming> streamings){
        List<Streaming> StreamingsFound = new ArrayList<>();
        streamings.forEach(streaming-> streamingService.findById(streaming.getId()).ifPresent(StreamingsFound::add));

        return StreamingsFound;
    }








}
