package com.emresutisna.siar.dao.impl;

import java.io.Serializable;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.emresutisna.siar.commons.impl.BasicDaoImpl;
import com.emresutisna.siar.dao.UserDao;
import com.emresutisna.siar.model.UserEntity;

@Repository
public class UserDaoImpl extends BasicDaoImpl<UserEntity> implements UserDao, Serializable {
	private static final long serialVersionUID = -3674474281953435268L;

	public boolean checkAvailable(String userName) {
        Assert.notNull(userName);
        Query query= getSessionFactory().getCurrentSession()
        		.createQuery("select count(*) from " + domainClass.getName() + " u where u.username = :username")
        		.setParameter("username", userName);        		
        int count = (int) query.list().size();
        return count < 1;
    }

	public UserEntity loadUserByUserName(String userName) {
	        Assert.notNull(userName);       
	        UserEntity user = null;
	        Query query = getSessionFactory().getCurrentSession()
	        		.createQuery("select u from " + domainClass.getName()
	                        + " u where u.username = :username").setParameter("username", userName);
	        try {
	                user = (UserEntity) query.uniqueResult();
	        } catch(NonUniqueResultException e) {
	                //do nothing
	        }         
	        return user;
	}
}