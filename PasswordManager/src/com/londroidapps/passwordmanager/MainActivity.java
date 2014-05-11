package com.londroidapps.passwordmanager;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et1, et2, et3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et3 = (EditText) findViewById(R.id.et3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void addword(View view) {
		AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
				"administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();

		String word = et1.getText().toString();
		String translation = et2.getText().toString();
		String tag = et3.getText().toString();

		if (word.length() == 0) {
			Toast.makeText(this, "You must specify a word", Toast.LENGTH_SHORT)
					.show();
			return;
		}

		ContentValues record = new ContentValues();
		record.put("word", word);
		record.put("translation", translation);
		record.put("tag", tag);

		bd.insert("vocabulary", null, record);
		bd.close();

		et1.setText("");
		et2.setText("");
		et3.setText("");
		Toast.makeText(this, "Data was added", Toast.LENGTH_SHORT).show();
	}

	public void findword(View view) {
		AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
				"administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();

		String word = et1.getText().toString();
		Cursor cursor = bd.rawQuery(
				"select translation, tag from vocabulary where word = '" + word
						+ "'", null);

		if (cursor.moveToFirst()) {
			et2.setText(cursor.getString(0));
			et3.setText(cursor.getString(1));
		} else
			Toast.makeText(this, "This word was not found", Toast.LENGTH_SHORT)
					.show();
		bd.close();
	}

	public void getlist(View view) {
		Intent intent = new Intent(this, VocabularyListActivity.class);
		startActivity(intent);
		// TODO uncomment this finish call
		// finish();
	}

}
