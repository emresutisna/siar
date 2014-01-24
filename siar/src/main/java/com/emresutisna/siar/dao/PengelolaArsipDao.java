package com.emresutisna.siar.dao;

import java.util.List;

import com.emresutisna.siar.commons.BasicDao;
import com.emresutisna.siar.model.PengelolaArsip;

public interface PengelolaArsipDao extends BasicDao<PengelolaArsip> {
	public List<PengelolaArsip> getAllUnique(Long idSubUnitKerja);
}
