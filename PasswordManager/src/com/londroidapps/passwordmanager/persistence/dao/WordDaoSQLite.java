package com.londroidapps.passwordmanager.persistence.dao;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.londroidapps.passwordmanager.persistence.domain.Word;

public class WordDaoSQLite extends AbstractWordDaoSQLite {

	public WordDaoSQLite(Context contextParam, String nameParam, CursorFactory factoryParam, int versionParam) {
		super(contextParam, nameParam, factoryParam, versionParam);
	}
	
	@Override
	public void createImpl(Word word) {
		// database.insert(...)
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImpl(Word word) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Word findImpl(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteImpl(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Word> findAllImpl() {
		// TODO Auto-generated method stub
		return null;
	}
}
