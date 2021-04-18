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
}
