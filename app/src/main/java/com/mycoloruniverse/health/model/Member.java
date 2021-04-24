package com.mycoloruniverse.health.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.mycoloruniverse.health.presenter.VisualInterfaceList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Member extends RoomJsonBase {
    @NonNull
    @PrimaryKey
    private String guid;
    @NonNull
    private String name;

    // @Ignore
    // EventDataBase


    // propertyValues хранит значение элементов интерфейса
    // <property_element_guid, property_element_value>
    @Ignore
    private final Map<String, String> propertyValues = new HashMap<>();
    @Ignore
    private final List<VisualEventBased> properties = new ArrayList<>();

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

    private void createPropertyJson() {
        VisualInterface visualInterface = VisualInterfaceList.getInstance().get("member");




        // visualInterface.getValues()

        // getProperty_json();



    }

}
