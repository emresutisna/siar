package com.emresutisna.siar.dao;

import java.util.List;

import com.emresutisna.siar.commons.BasicDao;
import com.emresutisna.siar.model.SuratMasuk;

public interface SuratMasukDao extends BasicDao<SuratMasuk> {
	public List<SuratMasuk> getAllUnique(Long idSubUnitKerja, String tahun);
	public Long getNextNoUrut(Long idSubUnitKerja, String tahun);
}
