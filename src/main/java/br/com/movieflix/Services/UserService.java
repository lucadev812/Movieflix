package br.com.movieflix.Services;

import br.com.movieflix.Controller.Request.UserRequest;
import br.com.movieflix.Repository.UserRepository;
import br.com.movieflix.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;






    public User save(User user){

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        return repository.save(user);
    }







}
