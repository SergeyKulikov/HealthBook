package com.mycoloruniverse.health;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;


@Entity
public class EventFile {
    @NonNull
    @PrimaryKey
    private String guid;
    private String member_guid;
    private String description;

    @Ignore
    private final List<Event> events = new ArrayList<>();

    public EventFile(String guid, String member_guid, String description) {
        this.guid = guid;
        this.member_guid = member_guid;
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMember_guid() {
        return member_guid;
    }

    public void setMember_guid(String member_guid) {
        this.member_guid = member_guid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Event> getEvents() {
        return events;
    }
}
