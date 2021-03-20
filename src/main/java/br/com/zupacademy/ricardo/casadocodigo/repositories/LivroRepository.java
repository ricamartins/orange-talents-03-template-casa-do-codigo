package br.com.zupacademy.ricardo.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.ricardo.casadocodigo.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
