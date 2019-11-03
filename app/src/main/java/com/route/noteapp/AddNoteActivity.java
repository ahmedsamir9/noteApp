package com.route.noteapp;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.route.noteapp.DataBase.Model.Note;
import com.route.noteapp.DataBase.Model.noteviewmodel;
import com.route.noteapp.DataBase.NoteDataBase;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText title;
    protected EditText date;
    protected EditText desc;
    protected Button add;
    protected Spinner spinner;
    noteviewmodel noteviewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_add_note);
        noteviewmodel = ViewModelProviders.of(this).get(com.route.noteapp.DataBase.Model.noteviewmodel.class);
        initView();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add) {
            //Todo: validation
            String sTitle = title.getText().toString();
            String sDate = date.getText().toString();
            String sDetails = desc.getText().toString();
            int priorty=spinner.getSelectedItemPosition()+1;

            Note note=new Note(sTitle,sDetails,sDate,priorty);
            noteviewmodel.insert(note);

            finish();


        }
    }

    private void initView() {
        title = (EditText) findViewById(R.id.title);
        date = (EditText) findViewById(R.id.date);
        desc = (EditText) findViewById(R.id.desc);
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(AddNoteActivity.this);
        spinner = (Spinner) findViewById(R.id.spinner);
    }
}
