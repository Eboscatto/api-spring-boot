package br.com.apispringboot.projetoApi.repository;

import br.com.apispringboot.projetoApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Consulta manual utilizando uma <Query>
    @Query("SELECT u FROM User u WHERE u.id > :id")

    public List<User> findAllMoreThan(@Param("id") Long Id);

    // Consulta utilizando a palavra reservada <GreaterThan> do Spring Data
    public List<User> findByIdGreaterThan(Long id);

    public List<User> findByNameIgnoreCase(String name);

}
