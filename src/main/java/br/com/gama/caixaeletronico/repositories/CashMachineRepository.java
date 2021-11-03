package br.com.gama.caixaeletronico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gama.caixaeletronico.entities.CashMachine;

@Repository
public interface CashMachineRepository extends JpaRepository<CashMachine, Integer> {
	
	@Query(value = "select sum(c.currency * c.amount) from CashMachine c")
	Integer getSumMoney();
}
