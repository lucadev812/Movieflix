package br.com.movieflix.Services;

import br.com.movieflix.Repository.CategoryRepository;
import br.com.movieflix.Repository.StreamingRepository;
import br.com.movieflix.entity.Streaming;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;


    private final CategoryRepository categoryRepository;

    public List<Streaming> findAll(){
        return  repository.findAll();
    }

    public  Streaming saveStreaming(Streaming streaming){

        return repository.save(streaming);
    }

    public Optional<Streaming> findById(Long id){

        return repository.findById(id);
    }

    public void deleteStreamingById(Long id){
        repository.deleteById(id);
    }

}
