package com.mycoloruniverse.health;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;

import java.util.ArrayList;
import java.util.List;

/** Класс для хранения данных интерфейса (записей). Аналог записи в БД. */

@Entity(primaryKeys = { "visualInterface", "ID" })
public class VisualInterfaceData {
    @NonNull
    String visualInterface;   // Название интерфейса
    @NonNull
    String ID; // ID записи
    String parentVisualInterface; // родительский интерфейс
    String parentID; // ID родительской записи

    // Это поле служет для записи строи JSON. В нем хранится records.
    // Когда Room читает это поле, то срабатывает setElements_data(String elements_data)
    // Как только данные получены они переводтся в GSON, который заполняет список
    // List<VisualInterfaceDataItem> records = new ArrayList<>();
    // в дальнейшем records используется для получения значения, когда отображается
    // конкретный элемент.
    // Также работает в обратную сторону: перед записью в Room необходимо
    // вызвать формирование JSON по данным
    // List<VisualInterfaceDataItem> records = new ArrayList<>();
    // собирвется JSON потом как строка сохраняется в elements_data, а Room пишет ее
    // в таблицу.

    String elements_data;

    @Ignore
    // Это данные записи по элементам
            List<VisualInterfaceDataItem> records = new ArrayList<>();

    @Ignore
    // Это ссылка на подчиненные интерфейсы
            List<VisualInterfaceData> children = new ArrayList<>();

    @NonNull
    public String getVisualInterface() {
        return visualInterface;
    }

    public void setVisualInterface(@NonNull String visualInterface) {
        this.visualInterface = visualInterface;
    }

    @NonNull
    public String getID() {
        return ID;
    }

    public void setID(@NonNull String ID) {
        this.ID = ID;
    }

    public String getParentVisualInterface() {
        return parentVisualInterface;
    }

    public void setParentVisualInterface(String parentVisualInterface) {
        this.parentVisualInterface = parentVisualInterface;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public List<VisualInterfaceDataItem> getRecords() {
        return records;
    }

    public void setRecords(List<VisualInterfaceDataItem> records) {
        this.records = records;
    }

    public List<VisualInterfaceData> getChildren() {
        return children;
    }

    public void setChildren(List<VisualInterfaceData> children) {
        this.children = children;
    }

    public String getElements_data() {
        return elements_data;
    }

    public void setElements_data(String elements_data) {
        this.elements_data = elements_data;
    }



}
