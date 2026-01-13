package br.com.movieflix.Controller.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id,
                           String name,
                           String email) {
}
