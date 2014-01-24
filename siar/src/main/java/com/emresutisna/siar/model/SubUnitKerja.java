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
@Table(name="T_SubUnitKerja")
public class SubUnitKerja implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3240280182094734665L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="namaSubUnitKerja", length=100, nullable=false)
	private String namaSubUnitKerja;
		
	@ManyToOne
	@JoinColumn(name="idUnitKerja",nullable=false)
	private UnitKerja unitKerja;	
	
	@Column(name="alamat1", length=200, nullable=true)
	private String alamat1;
	
	@Column(name="alamat2", length=200, nullable=true)
	private String alamat2;
	
	@Column(name="jabatanKepala", length=150, nullable=true)
	private String jabatanKepala;
	
	@Column(name="namaKepala", length=200, nullable=true)
	private String namaKepala;
	
	@Column(name="nipKepala", length=18, nullable=true)
	private String nipKepala;
	
	@OneToMany(mappedBy="subUnitKerja",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Arsip> arsips;
		
	@OneToMany(mappedBy="subUnitKerja",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<UserEntity> userEntities;
	
	@OneToMany(mappedBy="subUnitKerja",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Penandatangan> penandatangans;

	@OneToMany(mappedBy="subUnitKerja",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<PengelolaArsip> pengelolaArsips;
	
	public String getNamaSubUnitKerja() {
		return namaSubUnitKerja;
	}

	public void setNamaSubUnitKerja(String namaSubUnitKerja) {
		this.namaSubUnitKerja = namaSubUnitKerja;
	}

	public UnitKerja getUnitKerja() {
		return unitKerja;
	}

	public void setUnitKerja(UnitKerja unitKerja) {
		this.unitKerja = unitKerja;
	}

	public String getAlamat1() {
		return alamat1;
	}

	public void setAlamat1(String alamat1) {
		this.alamat1 = alamat1;
	}

	public String getAlamat2() {
		return alamat2;
	}

	public void setAlamat2(String alamat2) {
		this.alamat2 = alamat2;
	}

	public String getJabatanKepala() {
		return jabatanKepala;
	}

	public void setJabatanKepala(String jabatanKepala) {
		this.jabatanKepala = jabatanKepala;
	}

	public String getNamaKepala() {
		return namaKepala;
	}

	public void setNamaKepala(String namaKepala) {
		this.namaKepala = namaKepala;
	}

	public String getNipKepala() {
		return nipKepala;
	}

	public void setNipKepala(String nipKepala) {
		this.nipKepala = nipKepala;
	}

	public List<Arsip> getArsips() {
		return arsips;
	}

	public void setSuratMasuks(List<Arsip> arsips) {
		this.arsips = arsips;
	}

	public List<UserEntity> getUserEntities() {
		return userEntities;
	}

	public void setUserEntities(List<UserEntity> userEntities) {
		this.userEntities = userEntities;
	}

	public List<Penandatangan> getPenandatangans() {
		return penandatangans;
	}

	public void setPenandatangans(List<Penandatangan> penandatangans) {
		this.penandatangans = penandatangans;
	}

	public List<PengelolaArsip> getPengelolaArsips() {
		return pengelolaArsips;
	}

	public void setPengelolaArsips(List<PengelolaArsip> pengelolaArsips) {
		this.pengelolaArsips = pengelolaArsips;
	}
}
