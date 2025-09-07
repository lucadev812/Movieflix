package br.com.movieflix.Controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name){
}
