package br.com.gama.caixaeletronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.gama.caixaeletronico.entities.CashMachine;
import br.com.gama.caixaeletronico.repositories.CashMachineRepository;

@Service
public class CashMachineService {

	@Autowired
	private CashMachineRepository repository;
	
	public List<CashMachine> getAll(){		
		return this.repository.findAll(Sort.by(Sort.Direction.DESC, "currency"));
	}
	
	public Integer getSumMoney() {		
		return repository.getSumMoney();
	}
	
	public CashMachine setCurrencyAmount(CashMachine _cashMachine) {
		var result = repository.findById(_cashMachine.getCurrency());		
		if (!result.isPresent()) return null;
		CashMachine cashMachine = result.get();
		cashMachine.setAmount(cashMachine.getAmount() + _cashMachine.getAmount());
		repository.save(cashMachine);
		return cashMachine;		
	}
}
