package br.com.gama.caixaeletronico.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gama.caixaeletronico.entities.Withdraw;

@Repository
public interface WithdrawRepository extends JpaRepository<Withdraw, UUID> {
	
}
