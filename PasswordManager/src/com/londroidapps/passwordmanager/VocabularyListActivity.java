package com.londroidapps.passwordmanager;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VocabularyListActivity extends ListActivity {

	static final private ArrayList<String> myarray = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// call the database
		getall();
		// use the generated array
		setListAdapter(new ArrayAdapter<String>(this, R.layout.vocabulary_list,
				myarray));
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);

		// Set listener
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				getDetails(myarray.get(position));
			}
		});
	}

	public void getall() {
		myarray.clear();

		AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
				"administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		Cursor fila = bd.rawQuery("select * from vocabulary order by word",
				null);

		while (fila.moveToNext()) {
			// String hola = fila.getString(1);
			myarray.add(fila.getString(1));
		}

		bd.close();
	}

	public void getDetails(String word) {

		Intent intent = new Intent(this, WordDetailsActivity.class);
		intent.putExtra("word", word);
		startActivity(intent);
		// TODO
		// finish();
	}
}
