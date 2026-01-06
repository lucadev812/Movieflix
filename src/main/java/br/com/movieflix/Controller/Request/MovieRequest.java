package br.com.movieflix.Controller.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest (String title,
                           String description,
                           @JsonFormat
                           LocalDate releaseDate,
                           double rating,
                           List<Long> categories,
                           List<Long> streamings){
}
