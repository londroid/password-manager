package com.londroidapps.passwordmanager.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.londroidapps.passwordmanager.persistence.dao.WordDao;
import com.londroidapps.passwordmanager.persistence.dao.WordDaoSQLite;
import com.londroidapps.passwordmanager.persistence.domain.Word;

/**
 * This class will have factory methods for every persistence manager needed
 * 
 * @author david
 *
 */
public class PersistenceManager {

	private static Context context;
	private static String databaseName;
	private static CursorFactory cursorFactory;
	private static int version;
	
	private static boolean isSQLiteDb;
	private static WordDao instance;
	
	/**
	 * Call this first to configure a SQLite database
	 * @param contextParam
	 * @param nameParam
	 * @param factoryParam
	 * @param versionParam
	 */
	public static void setConfigForSQLite(Context contextParam, String nameParam, CursorFactory factoryParam, int versionParam) {
		context = contextParam;
		databaseName = nameParam;
		cursorFactory = factoryParam;
		version = versionParam;
		isSQLiteDb = true;
	}

	/**
	 * Factory method to return a persistence object to manage Words
	 * @return
	 */
	public static WordDao getWordDao() {
		if (isSQLiteDb) {
			if (instance == null) {
				instance = new WordDaoSQLite(context, databaseName, cursorFactory, version);
			}
			return instance;
		} else 
			return null;
	}
	
	//Example of usage (need previous initialization)
	public void exampleMethod() {
		WordDao wordDao = PersistenceManager.getWordDao();
		wordDao.create(new Word());
		wordDao.delete(1);
		//more
	}
}
