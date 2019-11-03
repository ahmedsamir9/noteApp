package com.route.noteapp.DataBase.Model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.route.noteapp.DataBase.NoteDataBase;

import java.util.List;

public class noteviewmodel extends AndroidViewModel {
  public MutableLiveData<List<Note>>notess = new MutableLiveData<>();
    public noteviewmodel(@NonNull Application application) {
        super(application);
    }

    public void load(){
        notess.postValue(NoteDataBase.getInstance(getApplication()).noteDAO().getNotes());
    }
    public void insert(Note note){
        NoteDataBase.getInstance(getApplication()).noteDAO().insertNote(note);
        load();
    }

}
