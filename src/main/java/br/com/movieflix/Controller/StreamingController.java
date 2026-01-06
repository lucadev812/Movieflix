package br.com.movieflix.Controller;



import br.com.movieflix.Controller.Request.StreamingRequest;
import br.com.movieflix.Controller.response.StreamingResponse;
import br.com.movieflix.Mapper.StreamingMapper;
import br.com.movieflix.Services.StreamingService;
import br.com.movieflix.entity.Streaming;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;


    @GetMapping()
    public ResponseEntity<List<StreamingResponse>>getAllstreamings(){
        List<StreamingResponse> streamings = streamingService.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();
        return ResponseEntity.ok(streamings);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveStreaming(@RequestBody StreamingRequest request){
        Streaming  newStreaming = StreamingMapper.toStreaming(request);
        Streaming saveStreaming = streamingService.saveStreaming(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(saveStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id ){
        return streamingService.findById(id)
                .map(streaming-> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id){
        streamingService.deleteStreamingById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }




}
