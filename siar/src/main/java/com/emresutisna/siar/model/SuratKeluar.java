package com.emresutisna.siar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_Surat_Keluar")
@PrimaryKeyJoinColumn(name="idSuratKeluar", referencedColumnName="id")
public class SuratKeluar extends Arsip{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3001865096423934755L;

	@Column(name="tujuanSurat", length=250, nullable=false)
	private String tujuanSurat;
	
	@Temporal(TemporalType.DATE)
	@Column(name="tglKirim", nullable=false)
	private Date tglKirim;

	public String getTujuanSurat() {
		return tujuanSurat;
	}

	public void setTujuanSurat(String tujuanSurat) {
		this.tujuanSurat = tujuanSurat;
	}

	public Date getTglKirim() {
		return tglKirim;
	}

	public void setTglKirim(Date tglKirim) {
		this.tglKirim = tglKirim;
	}
}
