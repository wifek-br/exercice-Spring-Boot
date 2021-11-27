package com.examen.tp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.tp.model.Compte;
import com.examen.tp.model.Operation;
import com.examen.tp.service.CompteService;
import com.examen.tp.service.OperationSerivce;


@RestController
@RequestMapping("/operation")
public class OperationController {
	private final OperationSerivce operationService;
	private final CompteService compteService;
	public OperationController(OperationSerivce operationService, CompteService compteService) {
		super();
		this.operationService = operationService;
		this.compteService = compteService;
	}
	@PostMapping("/versement/{id}")
    public ResponseEntity<Operation> versement(@RequestBody Operation operation , @PathVariable("id") int id) {
        Compte compte= compteService.findById(id);
        compte.addOperation(operation);
        operation.setId(id);
        compte.setSolde(compte.getSolde()+operation.getMontant());
        Operation newOperation = operationService.addOperation(operation);
        return new ResponseEntity<>(newOperation, HttpStatus.CREATED);
    }
	@PostMapping("/retrait/{id}")
    public ResponseEntity<Operation> retrait(@RequestBody Operation operation , @PathVariable("id") int id) {
        Compte compte= compteService.findById(id);
        compte.addOperation(operation);
        operation.setId(id);
        compte.setSolde(compte.getSolde()-operation.getMontant());
        Operation newOperation = operationService.addOperation(operation);
        return new ResponseEntity<>(newOperation, HttpStatus.CREATED);
    }
	   @GetMapping("/findByCompte/{id}")
	    public ResponseEntity<List<Operation>> getOperationsByCompte(@PathVariable("id")int  id) {
	        Compte compte=compteService.findById(id);
	        List<Operation> operations = compte.getOperations();
	        return new ResponseEntity<>(operations, HttpStatus.OK);
	    }
	   
	   
}
