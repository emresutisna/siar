package com.emresutisna.siar.dao.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.emresutisna.siar.commons.impl.BasicDaoImpl;
import com.emresutisna.siar.dao.SuratMasukDao;
import com.emresutisna.siar.model.SuratMasuk;

@Repository
public class SuratMasukDaoImpl extends BasicDaoImpl<SuratMasuk> implements
		SuratMasukDao, Serializable {
	
	private static final long serialVersionUID = 4173944149508655178L;

	@SuppressWarnings("unchecked")
	@Override
	public List<SuratMasuk> getAllUnique(Long idSubUnitKerja, String tahun) {
        Assert.notNull(idSubUnitKerja);
        Assert.notNull(tahun);
        Query query= getSessionFactory().getCurrentSession()
        		.createQuery("from " + domainClass.getName() + " sm where sm.subUnitKerja.id = :id and sm.tahun = :tahun order by sm.noUrut")
        		.setParameter("id", idSubUnitKerja).setParameter("tahun", tahun);

		List<SuratMasuk> list = query.list();    
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long getNextNoUrut(Long idSubUnitKerja, String tahun) {
        Assert.notNull(idSubUnitKerja);
        Assert.notNull(tahun);
        Query query= getSessionFactory().getCurrentSession()
        		.createQuery("select max(sm.noUrut) from " + domainClass.getName() + " sm where sm.subUnitKerja.id = :id and sm.tahun = :tahun ")
        		.setParameter("id", idSubUnitKerja).setParameter("tahun", tahun);
		List list = query.list();
		Iterator itr = list.iterator();
		Long noUrut = 0L;
		while (itr.hasNext()) {
			noUrut = (Long) itr.next();
		}			
		if(noUrut == null){
			noUrut = 0L;
		}
        return noUrut+1;
	}	
}
