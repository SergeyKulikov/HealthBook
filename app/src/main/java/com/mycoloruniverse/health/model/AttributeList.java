package com.mycoloruniverse.health.model;

import com.mycoloruniverse.health.Settings;

import java.util.ArrayList;
import java.util.List;

public class AttributeList {
    private static AttributeList instance;
    private final List<Attribute> attributes = new ArrayList<>();

    public static AttributeList getInstance() {
        if (instance == null) {
            instance = new AttributeList();
        }
        return instance;
    }

    private AttributeList() {
        /*
        attributes.add(new Attribute("temperature", "Температура", Settings.Double));
        attributes.add(new Attribute("health", "Сомочувствие", Settings.MultilineText));
        attributes.add(new Attribute("allergy", "Аллергия (описание)", Settings.MultilineText));
        attributes.add(new Attribute("diarrhea", "Понос (описание)", Settings.MultilineText));
        attributes.add(new Attribute("constipation", "Запор (описание)", Settings.MultilineText));
        attributes.add(new Attribute("feces", "Кал", Settings.MultilineText));
        attributes.add(new Attribute("urine", "Моча", Settings.MultilineText));
        attributes.add(new Attribute("injury", "Травма", Settings.MultilineText));
        attributes.add(new Attribute("cut", "Порез", Settings.MultilineText));
        attributes.add(new Attribute("burn", "Ожег", Settings.MultilineText));
        attributes.add(new Attribute("taking medicine", "Прием лекаства (название)",
                Settings.Text, "Доза", Settings.Double));

         */
    }

}
