package com.londroidapps.passwordmanager.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.londroidapps.passwordmanager.AdminSQLiteOpenHelper;
import com.londroidapps.passwordmanager.persistence.domain.Word;

/**
 * Initializes an instance of a SQLiteDatabase and defines template
 * methods for the basic operations
 * 
 * @author david
 *
 */
public abstract class AbstractWordDaoSQLite extends AdminSQLiteOpenHelper implements WordDao {
	
	protected SQLiteDatabase database;
	
	protected AbstractWordDaoSQLite(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		this.database = super.getWritableDatabase();
	}
	
	public abstract void createImpl(Word word);
	
	public abstract void updateImpl(Word word);
	
	public abstract Word findImpl(Integer id);
	
	public abstract void deleteImpl(Integer id);
	
	public abstract List<Word> findAllImpl();
	

	public void onCreate(SQLiteDatabase database) {
		database.execSQL("create table vocabulary(id integer primary key, word text, translation text, tag text)");
	}
	
	public void create(Word word) {
		database.beginTransaction();
		try {
			createImpl(word);
			database.setTransactionSuccessful();
		} finally {
			database.endTransaction();
		}	
	}

	public Word find(Integer id) {
		database.beginTransaction();
		Word word = null;
		try {
			word = findImpl(id);
			database.setTransactionSuccessful();
		} finally {
			database.endTransaction();
		}	
		return word;
	}

	public void update(Word word) {
		database.beginTransaction();
		try {
			updateImpl(word);
			database.setTransactionSuccessful();
		} finally {
			database.endTransaction();
		}	
	}

	public List<Word> findAll() {
		database.beginTransaction();
		List<Word> words = new ArrayList<Word>();
		
		try {
			words = findAllImpl();
			database.setTransactionSuccessful();
		} finally {
			database.endTransaction();
		}
		
		return words;
	}

	
	public void delete(Integer id) {
		database.beginTransaction();
		try {
			deleteImpl(id);
			database.setTransactionSuccessful();
		} finally {
			database.endTransaction();
		}
	}
}
