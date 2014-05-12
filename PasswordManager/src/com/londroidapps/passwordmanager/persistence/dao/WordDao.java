package com.londroidapps.passwordmanager.persistence.dao;

import java.util.List;

import com.londroidapps.passwordmanager.persistence.domain.Word;

public interface WordDao {

	public void create(Word word);
	
	public Word find(Integer id);
	
	public void update(Word word);
	
	public List<Word> findAll();
	
	public void delete(Integer id);
	
}
