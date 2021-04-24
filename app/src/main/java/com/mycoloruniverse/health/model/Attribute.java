package com.mycoloruniverse.health.model;

import androidx.annotation.NonNull;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Это всегда значения для выбора
 * из них можно создать фиксированные или расширяемые списки
 */


// @Entity
public class Attribute {
    @NonNull
    @PrimaryKey
    private String guid;
    private String propertyValues;  // Эта переменная формирует JSON строку из propertyList

    // Атрибуты предназваничены могут содержать несколько Property
    // Для простоты сделаем им 3 значения максимум
    @Ignore
    private final VisualInterface visualInterface = new VisualInterface();

    public Attribute(String guid, String propertyValues) {
        this.guid = guid;

        setVisualInterface(propertyValues);
    }

    private void setVisualInterface(String propertyValues) {
        try {
            JSONObject jsonObject = new JSONObject(propertyValues);

            JSONArray jsonArray = jsonObject.getJSONArray("propertylist");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonPropertyValue = jsonArray.getJSONObject(i);
                VisualEventBased visualElement = visualInterface.find(jsonPropertyValue.get("id").toString());

                if (visualElement == null) break;
                visualElement.setValue(jsonPropertyValue.getString("value"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Ignore
    public Attribute(@NotNull String guid) {
        this.guid = guid;
    }

    @NotNull
    public String getGuid() {
        return guid;
    }

    public void setGuid(@NotNull String guid) {
        this.guid = guid;
    }

    public VisualInterface getVisualInterface() {
        return visualInterface;
    }

    private void setPropertyList(VisualInterface visualInterface) {
        // TODO: доделать
    }

    public String getPropertyValues() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (String group : visualInterface.getValues().keySet()) {
            if (visualInterface.getValues().get(group) == null) continue;

            for (VisualEventBased visualElement : visualInterface.getValues().get(group)) {
                // объект ключ-значение
                JSONObject key_value = new JSONObject();
                key_value.put(visualElement.getGuid(), visualElement.getValue());

                // пихаем в массив
                jsonArray.put(key_value);
            }
        }

        jsonObject.put("propertylist", jsonArray);

        return jsonObject.toString();
    }

    public void setPropertyValues(String propertyValues) {
        this.propertyValues = propertyValues;
        setVisualInterface(propertyValues);
    }
}
