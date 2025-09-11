package br.com.movieflix.Services;



import br.com.movieflix.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

}
