package br.com.gama.caixaeletronico.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="withdraw")
public class Withdraw {

	@Id
	private UUID id;
	private LocalDateTime createAt;
	private Integer value;
	
	public Withdraw() {
		id = UUID.randomUUID();
		createAt = LocalDateTime.now();
		value = 0;
	}		

	public Withdraw(Integer value) {
		id = UUID.randomUUID();
		createAt = LocalDateTime.now();
		this.value = value;
	}

	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public LocalDateTime getCreateAt() {
		return createAt;
	}



	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}



	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
