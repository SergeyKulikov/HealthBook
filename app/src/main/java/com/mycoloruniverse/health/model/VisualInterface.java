package com.mycoloruniverse.health.model;



import androidx.collection.ArrayMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** В property храним поля,в которые будут вводтся данные
 *
 * Нужно подготовить несколько шалонов данныех, чтоыб использовать это
 *
 * */


public class VisualInterface {
    private final List<String> groups = new ArrayList<>();
    private final Map<String, ArrayList<VisualEventBased>> properties = new ArrayMap<>();

    public VisualInterface(List<String> groups, Map<String, ArrayList<VisualEventBased>> properties) {
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

    public VisualInterface() {

    }

    public List<String> getGroups() {
        return groups;
    }

    public VisualEventBased addItem(String group, VisualEventBased visualElement) {
        VisualEventBased new_visualElement;
        ArrayList<VisualEventBased> visualElementMap;
        if (this.properties.containsKey(group)) { // группа уже создана
            visualElementMap = this.properties.get(group); // берем список в группе
        } else {
            visualElementMap = new ArrayList<>();
        }
        visualElementMap.add(visualElement);
        this.properties.put(group, visualElementMap);
        new_visualElement = visualElement;

        if (!this.groups.contains(group)) { // Если не добавлена группа, то добавляем
            this.groups.add(group);
        }
        return new_visualElement;
    }

    public void setProperty(VisualInterface visualInterface) {
        // TODO: проверить утечку памяти, т.к. не удалил вложенный Map
        this.properties.clear();
        if (visualInterface != null) return;
        if (visualInterface.getValues() != null) return;

        for (String group : visualInterface.getValues().keySet()) {
            if (visualInterface.getValues().get(group) == null) continue;

            this.properties.put(group, visualInterface.getValues().get(group));

            if (!this.groups.contains(group)) { // Если не добавлена группа, то добавляем
                this.groups.add(group);
            }
        }
    }

    public Map<String, ArrayList<VisualEventBased>> getValues() {
        return this.properties;
    }

    public VisualEventBased find(String id) {
        for (String group : this.groups) {
            if (group == null) continue;

            for (VisualEventBased visualElement : properties.get(group)) {
                if (visualElement == null) continue;
                if (visualElement.getGuid().equals(id)) return visualElement;
            }
        }
        return null;
    }
}
