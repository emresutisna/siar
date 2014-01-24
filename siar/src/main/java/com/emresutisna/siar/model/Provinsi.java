package com.emresutisna.siar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="T_Provinsi")
public class Provinsi implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8721969750252047150L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="kodeProvinsi", length=2, nullable=false, unique=true)
	private String kodeProvinsi;
	
	@Column(name="namaProvinsi", length=30, nullable=false)
	private String namaProvinsi;
	
	@OneToMany(mappedBy="provinsi",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Kota> kotas;

	public String getKodeProvinsi() {
		return kodeProvinsi;
	}

	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}

	public String getNamaProvinsi() {
		return namaProvinsi;
	}

	public void setNamaProvinsi(String namaProvinsi) {
		this.namaProvinsi = namaProvinsi;
	}

	public List<Kota> getKotas() {
		return kotas;
	}

	public void setKotas(List<Kota> kotas) {
		this.kotas = kotas;
	}
}
