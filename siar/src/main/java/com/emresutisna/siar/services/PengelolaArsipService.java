package com.emresutisna.siar.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emresutisna.siar.dao.PengelolaArsipDao;
import com.emresutisna.siar.model.PengelolaArsip;

@Service("pengelolaArsipService")
@Transactional(readOnly=true)
public class PengelolaArsipService implements Serializable {
	private static final long serialVersionUID = -2294711572707260799L;
	@Autowired
	private PengelolaArsipDao pengelolaArsipDao;

	@Transactional(readOnly=false)
	public void addPengelolaArsip(PengelolaArsip pengelolaArsip){
		getPengelolaArsipDao().add(pengelolaArsip);
	}	
	
	@Transactional(readOnly=false)
	public void updatePengelolaArsip(PengelolaArsip pengelolaArsip){
		getPengelolaArsipDao().update(pengelolaArsip);
	}
	
	@Transactional(readOnly=false)
	public void deletePengelolaArsip(PengelolaArsip pengelolaArsip){
		getPengelolaArsipDao().delete(pengelolaArsip);
	}
	
	public PengelolaArsip getById(Long id){
		return getPengelolaArsipDao().findById(id);
	}

	public List<PengelolaArsip> getAll(){	
		return getPengelolaArsipDao().findAll();
	}
	
	public List<PengelolaArsip> getAllForTable(Long idSubUnitKerja){	
		return getPengelolaArsipDao().getAllUnique(idSubUnitKerja);
	}
	
	public PengelolaArsipDao getPengelolaArsipDao() {
		return pengelolaArsipDao;
	}

	public void setPengelolaArsipDao(PengelolaArsipDao pengelolaArsipDao) {
		this.pengelolaArsipDao = pengelolaArsipDao;
	}	
}
