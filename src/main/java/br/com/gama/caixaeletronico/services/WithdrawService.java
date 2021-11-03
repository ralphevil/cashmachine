package br.com.gama.caixaeletronico.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.gama.caixaeletronico.entities.CashMachine;
import br.com.gama.caixaeletronico.entities.Withdraw;
import br.com.gama.caixaeletronico.repositories.CashMachineRepository;
import br.com.gama.caixaeletronico.repositories.WithdrawRepository;

@Service
public class WithdrawService {

	@Autowired
	private WithdrawRepository repository;
	
	@Autowired
	private CashMachineRepository repositoryCash;
		
	public List<Withdraw> getAllWithdraw(){	
		return repository.findAll();
	}
	
	public List<String> setWithdraw(Integer _value){
		if (!verifyWithdraw(_value)) throw new RuntimeException("Valor de saque inválido");
		List<String> bankNote = new ArrayList<String>();
		List<CashMachine> list = repositoryCash.findAll(Sort.by(Sort.Direction.DESC, "currency"));	
		var wrapper = new Object(){ Integer value; };
		wrapper.value = _value;
		
		list.forEach(item ->{				
			while ((int)(wrapper.value / item.getCurrency()) > 0 && item.getAmount() > 0) {
				wrapper.value -= item.getCurrency();
				item.setAmount(item.getAmount()-1);
				bankNote.add("R$"+ item.getCurrency());
			}
		});
		
		if(wrapper.value != 0) {
			throw new RuntimeException("Caixa temporáriamente indisponível");
		}else {
			repository.save(new Withdraw(_value));
			repositoryCash.saveAll(list);
			return bankNote;
		}
				
	}
	
	public boolean verifyWithdraw(Integer value) {		
		if(value <= 0 || value > repositoryCash.getSumMoney()) {
			return false;
		}else if(value % 5 != 0) {
			return false;
		}
		return true;
	}
	
}
