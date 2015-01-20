package com.yahoo.simpletodo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class EditItemActivity extends ActionBarActivity {

    String editText;
    String itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        editText = getIntent().getStringExtra("itemText");
        itemPosition = getIntent().getStringExtra("itemPosition");

        EditText editableText = (EditText)findViewById(R.id.etText);
        editableText.setText(editText);
        editableText.setSelection(editText.length());
    }

    public void onSubmit(View v) {
        this.finish();
    }

    public void onSave(View v) {

        EditText editableText = (EditText)findViewById(R.id.etText);
        String text = editableText.getText().toString();

        Intent i = new Intent();
        i.putExtra("itemText", text);
        i.putExtra("itemPosition", itemPosition);

        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
