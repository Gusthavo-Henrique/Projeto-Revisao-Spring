package br.com.gusthavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gusthavo.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
