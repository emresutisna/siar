package com.emresutisna.siar.dao;

import com.emresutisna.siar.commons.BasicDao;
import com.emresutisna.siar.model.UserEntity;

public interface UserDao extends BasicDao<UserEntity> {
    public boolean checkAvailable(String userName);
	public UserEntity loadUserByUserName(String userName);
}