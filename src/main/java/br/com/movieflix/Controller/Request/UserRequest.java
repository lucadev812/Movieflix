package br.com.movieflix.Controller.Request;

public record UserRequest(
                          String name,
                          String email,
                          String password) {
}
