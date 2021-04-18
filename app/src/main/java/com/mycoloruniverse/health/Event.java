package com.mycoloruniverse.health;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Любое действие - измерение температуры, посещение врача, прием лекарства
 * осмотр на наличие алергии....
 * */

@Entity
public class Event {
    @NonNull
    @PrimaryKey
    private String guid;
    private long time; // Дата и время наступления события
    @NonNull

    private String attribute_guid; // Тип из списка
    private String value1; // Значение (от типа атрибуту будет инрпретироваться по-разному)
    private String value2; // Значение (от типа атрибуту будет инрпретироваться по-разному)

    @NonNull
    public String getGuid() {
        return guid;
    }

    public void setGuid(@NonNull String guid) {
        this.guid = guid;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @NonNull
    public String getAttribute_guid() {
        return attribute_guid;
    }

    public void setAttribute_guid(@NonNull String attribute_guid) {
        this.attribute_guid = attribute_guid;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
