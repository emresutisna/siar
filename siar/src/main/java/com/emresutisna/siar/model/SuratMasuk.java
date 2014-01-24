package com.emresutisna.siar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_Surat_Masuk")
@PrimaryKeyJoinColumn(name="idSuratMasuk", referencedColumnName="id")
public class SuratMasuk extends Arsip implements Serializable{
	private static final long serialVersionUID = -3024572941284931591L;

	@Column(name="asalSurat", length=250, nullable=false)
	private String asalSurat;
	
	@Temporal(TemporalType.DATE)
	@Column(name="tglDisposisi", nullable=true)
	private Date tglDisposisi;
	
	public String getAsalSurat() {
		return asalSurat;
	}

	public void setAsalSurat(String asalSurat) {
		this.asalSurat = asalSurat;
	}

	public Date getTglDisposisi() {
		return tglDisposisi;
	}

	public void setTglDisposisi(Date tglDisposisi) {
		this.tglDisposisi = tglDisposisi;
	}
}
