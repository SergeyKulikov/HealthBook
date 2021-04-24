package com.mycoloruniverse.health.model;

import com.mycoloruniverse.health.Settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Это класс для создания записи реквизита из фрагмента, чтобы не нужно было настраивать
 * обображать произвольные поля.
 *
 * Класс не будет испоьзоваться для записи Room в локальную базу.
 * Когда выводтся формент, то в него передаются текущие значения полей,
 * При изменении этих полей они запоминаются в этом классе.
 *
 * Event содерджит один или несколько VisualEventBase, а базу данных пишется List<EventFileElement>.
 * ListFileElement содержит ссылку на
 *
 **/


public class VisualEventBased extends EventDataBased {
    // Тип значения. От него зависить, что выводить, TextEdit, RadioButton, Switch...
    private @Settings.AttributeTypes int type;

    private String hint;  // Значение, для вывода в пустом поле (только для TextEdit)
    private String caption;  // Заголовок сверху поля
    private PropertyButton button_action; // Пока не продумал до конца. Не используется.
    private String default_value; // Значение по умолчанию (для новых пустых полей)

    // Ввекторе храним значения для выбора (например варианты RadioButton или Spinner)
    // TODO: Наверное, пойдут не все объекты??
    private final Vector<Object> parameters = new Vector<>();
    private final Map<String, Object> visualParameterList = new HashMap<>();

    public VisualEventBased(String guid, String caption, String default_value, String value, String hint, @Settings.AttributeTypes int type) {
        super(guid, value);
        this.caption = caption;
        this.default_value = default_value;
        this.hint = hint;
        this.button_action = null;
        this.type = type;
    }

    public VisualEventBased(String guid, String caption, @Settings.AttributeTypes int type) {
        super(guid, null);
        this.caption = caption;
        this.default_value = null;
        this.hint = null;
        this.button_action = null;
        this.type = type;
    }

    public VisualEventBased(String guid, String caption, @Settings.AttributeTypes int type, Map<String, String> visualParameterList) {
        super(guid, null);
        this.caption = caption;
        this.default_value = null;
        this.hint = null;
        this.button_action = null;
        this.type = type;

        if (visualParameterList != null){
            this.visualParameterList.putAll(visualParameterList);
        }
    }

    public void addVisualParameter(String name, Object value) {
        this.visualParameterList.put(name, value);
    }


    public Map<String, Object> getVisualParameterList() {
        return visualParameterList;
    }

    public EventDataBased getData() {
        return new EventDataBased(this.getGuid(), this.getValue());
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDefault_value() {
        return default_value;
    }

    public void setDefault_value(String default_value) {
        this.default_value = default_value;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public PropertyButton getButton_action() {
        return button_action;
    }

    public void setButton_action(PropertyButton button_action) {
        this.button_action = button_action;
    }

    public @Settings.AttributeTypes int getType() {
        return type;
    }

    public void setType(@Settings.AttributeTypes int type) {
        this.type = type;
    }

    public VisualEventBased addParameter(Object object) {
        parameters.add(object);
        return this;
    }

    public void clearParameters() {
        parameters.clear();
    }

    public Vector<Object> getParameters() {
        return parameters;
    }
}
