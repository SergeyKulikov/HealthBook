package com.mycoloruniverse.health;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends RoomJsonBase {
    @NonNull
    @PrimaryKey
    private String guid;
    @NonNull
    private String name;

    @Ignore
    private final List<Property> properties = new ArrayList<>();

    public Member(String guid, String name) {
        this.guid = guid;
        this.name = name;
        this.properties.clear();
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
