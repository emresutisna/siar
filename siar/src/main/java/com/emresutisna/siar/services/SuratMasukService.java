package com.emresutisna.siar.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emresutisna.siar.dao.SuratMasukDao;
import com.emresutisna.siar.model.SuratMasuk;

@Service("suratMasukService")
@Transactional(readOnly=true)
public class SuratMasukService implements Serializable {
	private static final long serialVersionUID = 2899138432481904097L;
	@Autowired
	private SuratMasukDao suratMasukDao;

	@Transactional(readOnly=false)
	public void addSuratMasuk(SuratMasuk suratMasuk){
		suratMasuk.setNoUrut(getNextNoUrut(suratMasuk.getSubUnitKerja().getId(), suratMasuk.getTahun()));
		getSuratMasukDao().add(suratMasuk);
	}	
	
	@Transactional(readOnly=false)
	public void updateSuratMasuk(SuratMasuk suratMasuk){
		getSuratMasukDao().update(suratMasuk);
	}
	
	@Transactional(readOnly=false)
	public void deleteSuratMasuk(SuratMasuk suratMasuk){
		getSuratMasukDao().delete(suratMasuk);
	}
	
	public SuratMasuk getById(Long id){
		return getSuratMasukDao().findById(id);
	}

	public List<SuratMasuk> getAll(){	
		return getSuratMasukDao().findAll();
	}
	
	public List<SuratMasuk> getAllForTable(Long idSubUnitKerja, String tahun){	
		return getSuratMasukDao().getAllUnique(idSubUnitKerja, tahun);
	}
	
	public SuratMasukDao getSuratMasukDao() {
		return suratMasukDao;
	}

	public void setSuratMasukDao(SuratMasukDao suratMasukDao) {
		this.suratMasukDao = suratMasukDao;
	}	
	
	public Long getNextNoUrut(Long idSubUnitKerja, String tahun){
		return getSuratMasukDao().getNextNoUrut(idSubUnitKerja, tahun);
	}
}
