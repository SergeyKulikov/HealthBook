package com.mycoloruniverse.health;

/** Класс для хранения данных элементов интерфейса. Аналог полей записи в БД. */

public class VisualInterfaceDataItem {
    private String visualElementID;  // имя поля
    private Object visualElementValue;   // значение поля

    public VisualInterfaceDataItem(String visualElementID, Object visualElementValue) {
        this.visualElementID = visualElementID;
        this.visualElementValue = visualElementValue;
    }

    public String getVisualElementID() {
        return visualElementID;
    }

    public void setVisualElementID(String visualElementID) {
        this.visualElementID = visualElementID;
    }

    public Object getVisualElementValue() {
        return visualElementValue;
    }

    public void setVisualElementValue(Object visualElementValue) {
        this.visualElementValue = visualElementValue;
    }
}
