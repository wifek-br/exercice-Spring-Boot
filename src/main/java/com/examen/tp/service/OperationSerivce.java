package com.examen.tp.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.examen.tp.*;
import com.examen.tp.dao.OperationDao;
import com.examen.tp.model.Operation;

@Service
@Transactional
public class OperationSerivce {
	private final OperationDao operationDao;

	public OperationSerivce(OperationDao operationDao) {
		super();
		this.operationDao = operationDao;
	}
	public Optional<Operation> FindOperationById(int idO){
		return operationDao.findById(idO);
	}
	public List<Operation> FindAllComptes(){
		return operationDao.findAll();
	}
	public Operation addOperation(Operation operation) {
		return operationDao.save(operation);
	}

	public void deleteCompte (int idO) {
		operationDao.deleteById(idO);
	}
}
