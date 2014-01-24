package com.emresutisna.siar.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emresutisna.siar.dao.KlasifikasiArsipDao;
import com.emresutisna.siar.model.KlasifikasiArsip;

@Service("klasifikasiArsipService")
@Transactional(readOnly=true)
public class KlasifikasiArsipService implements Serializable {
	private static final long serialVersionUID = -275166838177210145L;
	@Autowired
	private KlasifikasiArsipDao klasifikasiArsipDao;
	
	@Transactional(readOnly=false)
	public void addKlasifikasiArsip(KlasifikasiArsip klasifikasiArsip){
		getKlasifikasiArsipDao().add(klasifikasiArsip);
	}

	@Transactional(readOnly=false)
	public void updateKlasifikasiArsip(KlasifikasiArsip klasifikasiArsip){
		getKlasifikasiArsipDao().update(klasifikasiArsip);
	}
	
	@Transactional(readOnly=false)
	public void deleteKlasifikasiArsip(KlasifikasiArsip klasifikasiArsip){
		getKlasifikasiArsipDao().delete(klasifikasiArsip);
	}
	
	public KlasifikasiArsip getById(Long id){
		return getKlasifikasiArsipDao().findById(id);
	}

	public List<KlasifikasiArsip> getAll(){	
		return getKlasifikasiArsipDao().findAll();
	}
	
	public KlasifikasiArsipDao getKlasifikasiArsipDao() {
		return klasifikasiArsipDao;
	}

	public void setKlasifikasiArsipDao(KlasifikasiArsipDao klasifikasiArsipDao) {
		this.klasifikasiArsipDao = klasifikasiArsipDao;
	}	
}
