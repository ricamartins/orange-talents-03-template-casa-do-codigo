package br.com.zupacademy.ricardo.casadocodigo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.ricardo.casadocodigo.models.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);
}
