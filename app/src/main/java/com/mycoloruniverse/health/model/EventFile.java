package com.mycoloruniverse.health.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Для того, чтобы не хранить данные в 3-х таблицах сделаем все в одной.
 * Файл в любом случае не будет слишком большим (доительные болезни по несколько месяцев я не
 * рассматриваю). Если возникнет необходмость, то с такой структурой это можно будет записать
 * в одельную таблицу, но сразу заложусь на эту возможность, введя поле "file_guid", которе будет
 * GUID экземпляра класса EventFile.
 *
 eventsJson =
 {
     "events":[
        {   "file_guid":"127671-128998-81js018-2980","time":2140908938900, "temperature measurement":["temperature":"38.7"],
            "file_guid":"127671-128998-81js018-2980","time":2141906538922, "taking medicine":["name":"38.7","value":"500", "unit","mg"]}
        }
    ]
 }
 */

@Entity
public class EventFile {
    @NonNull
    @PrimaryKey
    private String guid;
    private String member_guid;
    private String description;
    private String eventsJson;


    @Ignore
    private final List<EventFileAttribute> events = new ArrayList<>();

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

    public List<EventFileAttribute> getEvents() {
        return events;
    }

    public String getEventsJson() {
        return eventsJson;
    }

    public void setEventsJson(String eventsJson) {
        this.eventsJson = eventsJson;
    }
}
