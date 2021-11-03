package br.com.gama.caixaeletronico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.caixaeletronico.entities.Withdraw;
import br.com.gama.caixaeletronico.services.WithdrawService;

@RestController
@RequestMapping("/current-account")
public class WithdrawController {

	@Autowired
	private WithdrawService service;
	
	@GetMapping
	public ResponseEntity<List<Withdraw>> getAllWithdraw(){			
		return ResponseEntity.ok(service.getAllWithdraw());
	}
	
	@PostMapping("/withdraw")
	public ResponseEntity<List<String>> setWithdraw(@RequestBody Withdraw _withdraw){
		List<String> bankNote = service.setWithdraw(_withdraw.getValue());
		return ResponseEntity.ok(bankNote);
	}
	
}
