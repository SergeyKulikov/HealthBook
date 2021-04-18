package com.mycoloruniverse.health;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Member {
    @NonNull
    @PrimaryKey
    private String guid;
    @NonNull
    private String name;

    public Member(String guid, String name) {
        this.guid = guid;
        this.name = name;
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
