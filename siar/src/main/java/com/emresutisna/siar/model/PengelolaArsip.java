package com.emresutisna.siar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Pengelola_Arsip")
public class PengelolaArsip implements Serializable{
	private static final long serialVersionUID = -1912336428307673956L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="namaPengelola", length=100, nullable=false)
	private String namaPengelola;
	
	@Column(name="kodePengolah", length=30, nullable=false)
	private String kodePengolah;

	@ManyToOne
	@JoinColumn(name="idSubUnitKerja",nullable=false)
	private SubUnitKerja subUnitKerja;
	
	@OneToMany(mappedBy="pengelolaArsip")
	private List<Arsip> arsips;
	
	public String getNamaPengelola() {
		return namaPengelola;
	}

	public void setNamaPengelola(String namaPengelola) {
		this.namaPengelola = namaPengelola;
	}

	public String getKodePengolah() {
		return kodePengolah;
	}

	public void setKodePengolah(String kodePengolah) {
		this.kodePengolah = kodePengolah;
	}
	
	public SubUnitKerja getSubUnitKerja() {
		return subUnitKerja;
	}

	public void setSubUnitKerja(SubUnitKerja subUnitKerja) {
		this.subUnitKerja = subUnitKerja;
	}

	public List<Arsip> getArsips() {
		return arsips;
	}

	public void setArsips(List<Arsip> arsips) {
		this.arsips = arsips;
	}	
}
