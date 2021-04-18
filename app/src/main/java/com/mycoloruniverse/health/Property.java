package com.mycoloruniverse.health;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Это класс для создания записи реквизита из фрагмента, чтобы не нужно было настраивать
 * обображать произвольные поля
 *
 * Класс не будет испоьзоваться для записи Room в локальную базу
 **/


public class Property {
    private String id;
    private String value;

    private String hint;
    private String caption;
    private PropertyButton button_action;
    private String default_value;
    private @Settings.AttributeTypes int type;

    private final Vector<Object> parameters = new Vector<>();

    public Property(String id, String caption, String default_value, String value, String hint, @Settings.AttributeTypes int type) {
        super();
        this.id = id;
        this.caption = caption;
        this.default_value = default_value;
        this.value = value;
        this.hint = hint;
        this.button_action = null;
        this.type = type;
    }

    public Property(String id, String caption, @Settings.AttributeTypes int type) {
        this.id = id;
        this.caption = caption;
        this.default_value = null;
        this.value = null;
        this.hint = null;
        this.button_action = null;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Property addParameter(Object object) {
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
