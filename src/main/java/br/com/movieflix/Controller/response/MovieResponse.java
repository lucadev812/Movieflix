package br.com.movieflix.Controller.response;

import br.com.movieflix.entity.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(Long id,
                            String title,
                            String description,
                            @JsonFormat
                            LocalDate releaseDate,
                            double rating,
                            List<CategoryResponse> categories,
                            List<StreamingResponse> streamings
                                ) {
}
