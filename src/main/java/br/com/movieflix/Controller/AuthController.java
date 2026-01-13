package br.com.movieflix.Controller;


import br.com.movieflix.Controller.Request.LoginRequest;
import br.com.movieflix.Controller.Request.UserRequest;
import br.com.movieflix.Controller.response.LoginResponse;
import br.com.movieflix.Controller.response.UserResponse;
import br.com.movieflix.Mapper.UserMapper;
import br.com.movieflix.Services.TokenService;
import br.com.movieflix.Services.UserService;
import br.com.movieflix.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){


        User savedUser = userService.save(UserMapper.toUser(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(),request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();

        String token  = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));


    }

    //macaco testando
    // BANANA TESTE


}
