package com.emresutisna.siar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_Penandatangan")
public class Penandatangan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8900485693879053066L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="jabatanAnPenandatangan1", length=150, nullable=true)
	private String jabatanAnPenandatangan1;
	
	@Column(name="jabatanPenandatangan1", length=150, nullable=false)
	private String jabatanPenandatangan1;

	@Column(name="namaPenandatangan1", length=200, nullable=false)
	private String namaPenandatangan1;

	@Column(name="namaPenandatangan2", length=200, nullable=false)
	private String namaPenandatangan2;
	
	@Column(name="nipPenandatangan1", length=18, nullable=false)
	private String nipPenandatangan1;

	@Column(name="nipPenandatangan2", length=18, nullable=false)
	private String nipPenandatangan2;
	
	@ManyToOne
	@JoinColumn(name="idSubUnitKerja",nullable=false)
	private SubUnitKerja subUnitKerja;

	public String getJabatanAnPenandatangan1() {
		return jabatanAnPenandatangan1;
	}

	public void setJabatanAnPenandatangan1(String jabatanAnPenandatangan1) {
		this.jabatanAnPenandatangan1 = jabatanAnPenandatangan1;
	}

	public String getJabatanPenandatangan1() {
		return jabatanPenandatangan1;
	}

	public void setJabatanPenandatangan1(String jabatanPenandatangan1) {
		this.jabatanPenandatangan1 = jabatanPenandatangan1;
	}

	public String getNamaPenandatangan1() {
		return namaPenandatangan1;
	}

	public void setNamaPenandatangan1(String namaPenandatangan1) {
		this.namaPenandatangan1 = namaPenandatangan1;
	}

	public String getNamaPenandatangan2() {
		return namaPenandatangan2;
	}

	public void setNamaPenandatangan2(String namaPenandatangan2) {
		this.namaPenandatangan2 = namaPenandatangan2;
	}

	public String getNipPenandatangan1() {
		return nipPenandatangan1;
	}

	public void setNipPenandatangan1(String nipPenandatangan1) {
		this.nipPenandatangan1 = nipPenandatangan1;
	}

	public String getNipPenandatangan2() {
		return nipPenandatangan2;
	}

	public void setNipPenandatangan2(String nipPenandatangan2) {
		this.nipPenandatangan2 = nipPenandatangan2;
	}

	public SubUnitKerja getSubUnitKerja() {
		return subUnitKerja;
	}

	public void setSubUnitKerja(SubUnitKerja subUnitKerja) {
		this.subUnitKerja = subUnitKerja;
	}
}
