package com.examen.tp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.tp.model.*;

public interface OperationDao extends  JpaRepository<Operation,Integer>{

}
