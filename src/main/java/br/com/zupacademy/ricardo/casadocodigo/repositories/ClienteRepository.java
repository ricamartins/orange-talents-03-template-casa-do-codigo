package br.com.zupacademy.ricardo.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.ricardo.casadocodigo.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
