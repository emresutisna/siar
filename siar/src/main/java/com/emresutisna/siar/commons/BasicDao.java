package com.emresutisna.siar.commons;

import java.util.List;

public interface BasicDao<T> {
	public void add(T entity);
	public void update(T entity);
	public void delete(T entity);
	public List<T> findAll();
	public T findById(Long id);
}
