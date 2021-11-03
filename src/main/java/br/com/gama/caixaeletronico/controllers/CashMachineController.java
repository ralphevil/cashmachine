package br.com.gama.caixaeletronico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.caixaeletronico.entities.CashMachine;
import br.com.gama.caixaeletronico.services.CashMachineService;

@RestController
@RequestMapping("/cashmachine")
public class CashMachineController {

	@Autowired
	private CashMachineService service;
	
	@GetMapping
	public ResponseEntity<List<CashMachine>> findAll(){
		List<CashMachine> cash = service.getAll();
		return ResponseEntity.ok(cash);
	}
	
	@GetMapping("/money")
	public ResponseEntity<Integer> getSumMoney(){
		Integer cash = service.getSumMoney();
		return ResponseEntity.ok(cash);
	}
	
	@PutMapping
	public ResponseEntity<Void> setCurrencyAmount(@RequestBody CashMachine _cashMachine) {		
		var cash = service.setCurrencyAmount(_cashMachine);
		return cash != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
