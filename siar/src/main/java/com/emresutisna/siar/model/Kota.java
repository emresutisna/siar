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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="T_Kota", uniqueConstraints={@UniqueConstraint(columnNames={"kodeKota", "idProvinsi"})})
public class Kota implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1950353863231225799L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="kodeKota", length=2, nullable=false, unique=true)
	private String kodeKota;
	
	@Column(name="namaKota", length=100, nullable=false)
	private String namaKota;
	
	@ManyToOne
	@JoinColumn(name="idProvinsi",nullable=false)
	private Provinsi provinsi;	
	
	@OneToMany(mappedBy="kota",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<UnitKerja> unitKerjas;

	public String getKodeKota() {
		return kodeKota;
	}

	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
	}

	public String getNamaKota() {
		return namaKota;
	}

	public void setNamaKota(String namaKota) {
		this.namaKota = namaKota;
	}

	public Provinsi getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(Provinsi provinsi) {
		this.provinsi = provinsi;
	}

	public List<UnitKerja> getUnitKerjas() {
		return unitKerjas;
	}

	public void setUnitKerjas(List<UnitKerja> unitKerjas) {
		this.unitKerjas = unitKerjas;
	}
}