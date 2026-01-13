package br.com.movieflix.Config;

import br.com.movieflix.Services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SecurityFilter  extends OncePerRequestFilter {
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String authorizationHeader = request.getHeader("Authorization");



        if (Strings.isNotEmpty(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring("Bearer ".length());

             Optional<JWTUserData> optionalJWTUserData = tokenService.validateToken(token);
             if (optionalJWTUserData.isPresent()){
                JWTUserData jwtUserData = optionalJWTUserData.get();
                 UsernamePasswordAuthenticationToken authenticationToken =
                         new UsernamePasswordAuthenticationToken(
                                 jwtUserData,
                                 null,
                                 Collections.emptyList()
                         );

                 SecurityContextHolder.getContext().setAuthentication(authenticationToken);
             }

            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
