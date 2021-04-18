package com.mycoloruniverse.health;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = { Attribute.class, EventFile.class, Event.class, Member.class }, version = 1, exportSchema = false)

public abstract class AppDaoDatabase extends RoomDatabase {
    public abstract AppDao getDaoDatabase();

}
