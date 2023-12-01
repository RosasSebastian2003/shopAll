package com.shopall.demo.security;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.shopall.demo.security.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Builder;

/**
 * Esta clase representa un usuario en el sistema y implementa la interfaz UserDetails.
 * Contiene información como id, nombre, apellido, correo electrónico, contraseña y rol.
 */
@Entity
@Builder
public class User implements UserDetails {
    //Informacion del usuario
    @Id
    @SequenceGenerator( //Generamos una secuencia para el id
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, //AUTOINCREMENT
        generator = "user_sequence"
    )
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    //User Details Atributos
    @Enumerated(EnumType.STRING)
    public Role role;


    //Constructor vacio
    public User() {
    
    }

    //Constructor con parametros
    public User(long id, String firstName, String lastName, String email, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Métodos de UserDetails
    @Override //Arroja el tipo de usuario
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override //Arroja el nombre de usuario, el correo en nuestro caso
    public String getUsername() { //Subject
        return email;
    }
    
    @Override //Arroja el estado de la cuenta
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override //Arroja el estado de la cuenta   
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override //Arroja el estado de la cuenta
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override //Arroja el estado de la cuenta
    public boolean isEnabled() {
        return true;
    }
 
}
