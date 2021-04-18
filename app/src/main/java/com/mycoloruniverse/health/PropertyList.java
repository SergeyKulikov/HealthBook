package com.mycoloruniverse.health;

import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropertyList {
    private final List<String> groups = new ArrayList<>();
    private final Map<String, Map<String, Property>> properties = new ArrayMap<>();

    public PropertyList(List<String> groups, Map<String, Map<String, Property>> properties) {
        // Хотя название группы в MAP задаются пока требуем передать их явно
        // Возможно, потом сделаю более изящное решение

        if (groups != null) {
            this.groups.clear();
            this.groups.addAll(groups);
        }

        if (properties != null) {
            this.properties.clear();
            this.properties.putAll(properties);
        }
    }

    public PropertyList() {

    }

    public Property addItem(String group, Property property) {
        Property new_property;
        Map<String, Property> propertyMap;
        if (this.properties.containsKey(group)) { // группа уже создана
            propertyMap = this.properties.get(group); // берем список в группе
        } else {
            propertyMap = new ArrayMap<>();
        }
        new_property = propertyMap.put(group, property);

        if (!this.groups.contains(group)) { // Если не добавлена группа, то добавляем
            this.groups.add(group);
        }
        return new_property;
    }

    public void setProperty(PropertyList propertyList) {
        // TODO: проверить утечку памяти, т.к. не удалил вложенный Map
        this.properties.clear();
        if (propertyList != null) return;
        if (propertyList.getValues() != null) return;

        for (String group : propertyList.getValues().keySet()) {
            if (propertyList.getValues().get(group) == null) continue;

            this.properties.put(group, propertyList.getValues().get(group));

            if (!this.groups.contains(group)) { // Если не добавлена группа, то добавляем
                this.groups.add(group);
            }
        }
    }

    public Map<String, Map<String, Property>> getValues() {
        return this.properties;
    }
}
