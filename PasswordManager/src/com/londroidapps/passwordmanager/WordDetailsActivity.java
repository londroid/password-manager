package com.londroidapps.passwordmanager;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class WordDetailsActivity extends Activity {

	private TextView tv1;
	private String word;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.word_details);

		tv1 = (TextView) findViewById(R.id.tv1);

		Bundle bundle = getIntent().getExtras();

		word = bundle.getString("word");
		findWord();
	}

	public void findWord() {
		AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
				"administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		Cursor fila = bd.rawQuery(
				"select translation, tag from vocabulary where word = '" + word
						+ "'", null);
		if (fila.moveToFirst()) {
			tv1.setText(word + " - " + fila.getString(0) + " - "
					+ fila.getString(1));
		} else
			Toast.makeText(this, "You must specify a word", Toast.LENGTH_SHORT)
					.show();
		bd.close();
	}
}
