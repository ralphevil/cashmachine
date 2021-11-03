package br.com.gama.caixaeletronico.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cash_machine")
public class CashMachine {

	@Id	
	private Integer currency;
	private Integer amount;			
	
	public Integer getCurrency() {
		return currency;
	}	
	
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}	

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}	
	
}
