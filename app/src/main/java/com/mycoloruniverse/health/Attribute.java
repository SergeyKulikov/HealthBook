package com.mycoloruniverse.health;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Это всегда значения для выбора
 * из них можно создать фиксированные или расширяемые списки
 */


@Entity
public class Attribute {
    @NonNull
    @PrimaryKey
    private String guid;
    @NonNull
    private String name1;  // Значение которое вводится как пояснение, например "Аспирин"
    private AttributeType type1;

    private String name2;  // Дополнительное значение, например "50 мг"
    private AttributeType type2;

    public Attribute(String guid, String name1, AttributeType type1, String name2, AttributeType type2) {
        this.guid = guid;
        this.name1 = name1;
        this.name2 = name2;
        this.type1 = type1;
        this.type2 = type2;
    }

    @Ignore
    public Attribute(String guid, String name1, AttributeType type1) {
        this.guid = guid;
        this.name1 = name1;
        this.name2 = null;
        this.type1 = type1;
        this.type2 = AttributeType.None;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public AttributeType getType1() {
        return type1;
    }

    public void setType1(AttributeType type1) {
        this.type1 = type1;
    }

    public AttributeType getType2() {
        return type2;
    }

    public void setType2(AttributeType type2) {
        this.type2 = type2;
    }
}
