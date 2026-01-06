package br.com.movieflix.Controller;


import br.com.movieflix.Controller.Request.MovieRequest;
import br.com.movieflix.Controller.response.MovieResponse;
import br.com.movieflix.Mapper.MovieMapper;
import br.com.movieflix.Services.MovieService;
import br.com.movieflix.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public  ResponseEntity<MovieResponse> save (@RequestBody MovieRequest request){


        Movie save = movieService.save(MovieMapper.toMovie(request));

        return ResponseEntity.ok(MovieMapper.toMovieResponse(save));


    }


    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAllMovies(){

        return  ResponseEntity.ok(movieService.findAllMovies()
                .stream()
                .map(movie -> MovieMapper.toMovieResponse(movie))
                .toList());



    }


    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findMovieById(@PathVariable Long id){

        return  movieService.findByIdMovie(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());


    }



    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id,@RequestBody MovieRequest request){

       return movieService.updateMovie(id, MovieMapper.toMovie(request))
               .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
               .orElse(ResponseEntity.notFound().build());





    }


    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category){




        return ResponseEntity.ok( movieService.findByCategory(category)
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList());


    }
}


