package com.emresutisna.siar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_Arsip")
@Inheritance(strategy=InheritanceType.JOINED)
public class Arsip implements Serializable{
	private static final long serialVersionUID = 1800150221736701450L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="tahun", length=4, nullable=false)
	private String tahun;
	
	@Column(name="noUrut", nullable=false)
	private Long noUrut;
	
	@Column(name="noSurat", length=200, nullable=true)
	private String noSurat;
	
	@Column(name="indeks", length=150, nullable=false)
	private String indeks;
	
	@Column(name="perihal", length=200, nullable=true)
	private String perihal;
	
	@Lob
	@Column(name="isiRingkasan", nullable=true)
	private String isiRingkasan;

	@Temporal(TemporalType.DATE)
	@Column(name="tglSurat", nullable=true)
	private Date tglSurat;
	
	@Column(name="lampiran", length=100, nullable=true)
	private String lampiran;
	
	@Column(name="koreksi", length=200, nullable=true)
	private String koreksi;
	
	@ManyToOne
	@JoinColumn(name="idSubUnitKerja",nullable=false)
	private SubUnitKerja subUnitKerja;
	
	@ManyToOne
	@JoinColumn(name="idKlasifikasi",nullable=false)
	private KlasifikasiArsip klasifikasiArsip;
	
	@ManyToOne
	@JoinColumn(name="idPengelola",nullable=true)
	private PengelolaArsip pengelolaArsip;
	
	@Column(name="namaFile", length=250, nullable=true)
	private String namaFile;
	
	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}

	public Long getNoUrut() {
		return noUrut;
	}

	public void setNoUrut(Long noUrut) {
		this.noUrut = noUrut;
	}

	public String getNoSurat() {
		return noSurat;
	}

	public void setNoSurat(String noSurat) {
		this.noSurat = noSurat;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String getPerihal() {
		return perihal;
	}

	public void setPerihal(String perihal) {
		this.perihal = perihal;
	}

	public String getIsiRingkasan() {
		return isiRingkasan;
	}

	public void setIsiRingkasan(String isiRingkasan) {
		this.isiRingkasan = isiRingkasan;
	}

	public Date getTglSurat() {
		return tglSurat;
	}

	public void setTglSurat(Date tglSurat) {
		this.tglSurat = tglSurat;
	}

	public String getLampiran() {
		return lampiran;
	}

	public void setLampiran(String lampiran) {
		this.lampiran = lampiran;
	}

	public String getKoreksi() {
		return koreksi;
	}

	public void setKoreksi(String koreksi) {
		this.koreksi = koreksi;
	}

	public SubUnitKerja getSubUnitKerja() {
		return subUnitKerja;
	}

	public void setSubUnitKerja(SubUnitKerja subUnitKerja) {
		this.subUnitKerja = subUnitKerja;
	}

	public KlasifikasiArsip getKlasifikasiArsip() {
		return klasifikasiArsip;
	}

	public void setKlasifikasiArsip(KlasifikasiArsip klasifikasiArsip) {
		this.klasifikasiArsip = klasifikasiArsip;
	}

	public PengelolaArsip getPengelolaArsip() {
		return pengelolaArsip;
	}

	public void setPengelolaArsip(PengelolaArsip pengelolaArsip) {
		this.pengelolaArsip = pengelolaArsip;
	}

	public String getNamaFile() {
		return namaFile;
	}

	public void setNamaFile(String namaFile) {
		this.namaFile = namaFile;
	}
}
