package com.emresutisna.siar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Klasifikasi_Arsip")
public class KlasifikasiArsip implements Serializable{
	private static final long serialVersionUID = 2463625497806421899L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="kodeKlasifikasi", nullable=false, unique=true, length=7)
	private String kodeKlasifikasi;
	
	@Column(name="rincian", nullable=false, length=200)
	private String rincian;

	@OneToMany(mappedBy="klasifikasiArsip")
	private List<Arsip> arsips;
	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public String getKodeKlasifikasi() {
		return kodeKlasifikasi;
	}

	public void setKodeKlasifikasi(String kodeKlasifikasi) {
		this.kodeKlasifikasi = kodeKlasifikasi;
	}

	public String getRincian() {
		return rincian;
	}

	public void setRincian(String rincian) {
		this.rincian = rincian;
	}


	public List<Arsip> getArsips() {
		return arsips;
	}


	public void setArsips(List<Arsip> arsips) {
		this.arsips = arsips;
	}	
}
