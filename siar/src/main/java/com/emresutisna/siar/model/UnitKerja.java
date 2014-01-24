package com.emresutisna.siar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="T_UnitKerja")
public class UnitKerja implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1735879185127919642L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="namaUnitKerja", length=100, nullable=false)
	private String namaUnitKerja;
	
	@ManyToOne
	@JoinColumn(name="idKota",nullable=false)
	private Kota kota;	
	
	@OneToMany(mappedBy="unitKerja",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<SubUnitKerja> subUnitKerjas;

	public String getNamaUnitKerja() {
		return namaUnitKerja;
	}

	public void setNamaUnitKerja(String namaUnitKerja) {
		this.namaUnitKerja = namaUnitKerja;
	}

	public Kota getKota() {
		return kota;
	}

	public void setKota(Kota kota) {
		this.kota = kota;
	}

	public List<SubUnitKerja> getSubUnitKerjas() {
		return subUnitKerjas;
	}

	public void setSubUnitKerjas(List<SubUnitKerja> subUnitKerjas) {
		this.subUnitKerjas = subUnitKerjas;
	}
}
