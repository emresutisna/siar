package com.emresutisna.siar.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emresutisna.siar.dao.UserDao;
import com.emresutisna.siar.model.UserEntity;

@Service("userService")
@Transactional(readOnly=true)
public class UserService implements Serializable {
	private static final long serialVersionUID = -8273083099607389938L;
	@Autowired
	private UserDao userDao;
	
	private UserEntity loggedinUser;
	
	@Transactional(readOnly=false)
	public void addUser(UserEntity userEntity){
		getUserDao().add(userEntity);
	}
	
	@Transactional(readOnly=false)	
	public void updateUser(UserEntity userEntity){
		getUserDao().update(userEntity);
	}
	
	@Transactional(readOnly=false)
	public void deleteUser(UserEntity userEntity){
		getUserDao().delete(userEntity);
	}
	
	public UserEntity getById(Long id){
		return getUserDao().findById(id);
	}

	public List<UserEntity> getAll(){	
		return getUserDao().findAll();
	}

	public boolean checkAvailable(String username){
		return getUserDao().checkAvailable(username);
	}
	
	public UserEntity getByUsername(String username){
		return getUserDao().loadUserByUserName(username);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserEntity getLoggedinUser() {
		return loggedinUser;
	}

	public void setLoggedinUser(UserEntity loggedinUser) {
		this.loggedinUser = loggedinUser;
	} 
}
