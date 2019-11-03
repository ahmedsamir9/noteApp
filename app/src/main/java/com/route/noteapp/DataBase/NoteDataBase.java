package com.route.noteapp.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.route.noteapp.DataBase.DAOs.NoteDAO;
import com.route.noteapp.DataBase.Model.Note;

@Database(entities = {Note.class},version = 1,exportSchema = false)
public abstract class NoteDataBase extends RoomDatabase {

    private static final String DATABASE_NAME="Route-NoteDataBase";
    private static NoteDataBase dataBase;

    public abstract NoteDAO noteDAO();

   public static NoteDataBase getInstance(Context context){
       if(dataBase==null){
           //initialize
           dataBase= Room.databaseBuilder(context,
                   NoteDataBase.class,
                   DATABASE_NAME)
                   .fallbackToDestructiveMigration()
                   .allowMainThreadQueries()
                   .build();
       }

       return dataBase;


    }
}
