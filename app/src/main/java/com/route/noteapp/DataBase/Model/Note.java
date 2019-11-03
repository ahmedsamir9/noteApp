package com.route.noteapp.DataBase.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Mohamed Nabil Mohamed on 5/11/2019.
 * m.nabil.fci2015@gmail.com
 */

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo
    String title;
    @ColumnInfo(name = "content")
    String desc;
    @ColumnInfo
    String date;
    @ColumnInfo
    int priority;

    public Note() {
    }

    @Ignore
    public Note(String title, String desc, String date, int priority) {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
