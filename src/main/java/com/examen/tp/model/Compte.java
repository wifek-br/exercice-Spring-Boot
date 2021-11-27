package com.examen.tp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity(name="compte")
@Table (name="compte")
public class Compte implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private float solde;
	
	@Column(name="date")
	private Date date;
	
	@OneToMany(mappedBy = "compte", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Operation> operations;
	@Column(name="type")
	private String type;
	public Compte(int id, float solde, Date date, String type) {
		super();
		this.id = id;
		this.solde = solde;
		this.date = date;
		this.type = type;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public void addOperation(Operation operation) {
		this.operations.add(operation);
	}
	

}
