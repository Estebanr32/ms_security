package com.uc.ms_security.repository;

import com.uc.ms_security.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);

    @EntityGraph(attributePaths = {"profile"})
    Optional<User> findWithProfileById(Long id);

    @EntityGraph(attributePaths = {"sessions"})
    Optional<User> findWithSessionsById(Long id);

    @EntityGraph(attributePaths = {"userRoles", "userRoles.role"})  //Sustentación 
    Optional<User> findWithRolesById(Long id);                      // Acá se esta haciendo un Join de 3 niveles, osea uniendo 3 tablas, 
                                                                    //la tabla de User, la tabla de UserRole y la tabla de Role. 
                                                                    // Esto es para poder traer los roles del usuario en una sola consulta a la base de datos.
}



