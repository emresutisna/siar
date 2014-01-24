package com.emresutisna.siar.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.emresutisna.siar.commons.impl.BasicDaoImpl;
import com.emresutisna.siar.dao.PengelolaArsipDao;
import com.emresutisna.siar.model.PengelolaArsip;

@Repository
public class PengelolaArsipDaoImpl extends BasicDaoImpl<PengelolaArsip> implements
		PengelolaArsipDao, Serializable {
	
	private static final long serialVersionUID = 4173944149508655178L;

	@SuppressWarnings("unchecked")
	@Override
	public List<PengelolaArsip> getAllUnique(Long idSubUnitKerja) {
        Assert.notNull(idSubUnitKerja);
        Query query= getSessionFactory().getCurrentSession()
        		.createQuery("from " + domainClass.getName() + " pa where pa.subUnitKerja.id = :id")
        		.setParameter("id", idSubUnitKerja);
		List<PengelolaArsip> list = query.list();    
		return list;
	}	
}