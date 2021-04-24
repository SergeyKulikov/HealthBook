package com.mycoloruniverse.health.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mycoloruniverse.health.model.Attribute;
import com.mycoloruniverse.health.model.EventFile;
import com.mycoloruniverse.health.model.Member;


@Database(entities = { EventFile.class, Member.class }, version = 1, exportSchema = false)

public abstract class AppDaoDatabase extends RoomDatabase {
    public abstract AppDao getDaoDatabase();

}
