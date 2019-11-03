package com.route.noteapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.route.noteapp.Adapters.NotesAdapter;
import com.route.noteapp.DataBase.Model.Note;
import com.route.noteapp.DataBase.Model.noteviewmodel;
import com.route.noteapp.DataBase.NoteDataBase;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    NotesAdapter adapter;
    noteviewmodel noteview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         noteview = ViewModelProviders.of(this).get(com.route.noteapp.DataBase.Model.noteviewmodel.class);
         noteview.load();
           inti();
        subscrible();
    }

    @Override
    protected void onStart() {
        super.onStart();

     subscrible();
    }
    public void subscrible(){
        noteview.notess.observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                adapter.changeData(notes);
            }
        });
    }

    public void inti(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.recycler_view);
        setSupportActionBar(toolbar);
        layoutManager=new LinearLayoutManager(this);
        adapter=new NotesAdapter(noteview.notess.getValue());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setToggleclick(new NotesAdapter.onclick() {
            @Override
            public void onclicktoggle(int i) {

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
       /*         Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
       */
                startActivity(new Intent(HomeActivity.this,AddNoteActivity.class));

            }
        });
    }
}
