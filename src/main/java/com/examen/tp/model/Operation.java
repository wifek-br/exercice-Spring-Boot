package com.examen.tp.model;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="compte")
@Table(name="Operation")
public class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idO;
	@Column
	private Date date;
	
	@Column
	private float montant;
	@Column
	private String type;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Compte compte;
	@Column(name = "id")
	private int id;
	public Operation(int idO, Date date, float montant, int id) {
		super();
		this.idO = idO;
		this.date = date;
		this.montant = montant;
		this.id = id;
	}
	public int getIdO() {
		return idO;
	}
	public void setIdO(int idO) {
		this.idO = idO;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
