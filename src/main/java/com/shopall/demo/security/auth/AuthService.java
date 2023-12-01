package com.shopall.demo.security.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopall.demo.security.Role;

import com.shopall.demo.security.UserRepository;
import com.shopall.demo.security.config.JwtService;
import com.shopall.demo.security.User;

import lombok.RequiredArgsConstructor;
 

/**
 * Esta clase es responsable de manejar la autenticación y registro de usuarios.
 * Utiliza un objeto UserRepository para interactuar con la base de datos y un objeto PasswordEncoder para encriptar las contraseñas de los usuarios.
 * También utiliza un objeto JwtService para generar tokens JWT y un objeto AuthenticationManager para autenticar a los usuarios.
 */
@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService JwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Este método registra a un nuevo usuario en la base de datos.
     * Crea un objeto User con la información proporcionada en el objeto RegistrationRequest y lo guarda en la base de datos utilizando el objeto UserRepository.
     * Luego genera un token JWT utilizando el objeto JwtService y devuelve una respuesta de autenticación con el token.
     * @param request El objeto RegistrationRequest que contiene la información del usuario a registrar.
     * @return Una respuesta de autenticación que contiene un token JWT.
     */
    public AuthenticationResponse register(RegistrationRequest request) {
        var user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
        userRepository.save(user);
        var jwtToken = JwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    /**
     * Este método autentica a un usuario existente en la base de datos.
     * Utiliza el objeto AuthenticationManager para autenticar al usuario con las credenciales proporcionadas en el objeto AuthenticationRequest.
     * Si la autenticación es exitosa, genera un token JWT utilizando el objeto JwtService y devuelve una respuesta de autenticación con el token.
     * @param request El objeto AuthenticationRequest que contiene las credenciales del usuario a autenticar.
     * @return Una respuesta de autenticación que contiene un token JWT.
     */
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
        .orElseThrow();

        var jwtToken = JwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
