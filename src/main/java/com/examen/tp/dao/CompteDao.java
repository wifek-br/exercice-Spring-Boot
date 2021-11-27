package com.examen.tp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.tp.model.Compte;

public interface CompteDao extends JpaRepository<Compte,Integer> {

}
