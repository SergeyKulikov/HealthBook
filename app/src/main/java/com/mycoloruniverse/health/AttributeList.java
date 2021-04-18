package com.mycoloruniverse.health;

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
        attributes.add(new Attribute("temperature", "Температура", AttributeType.Double));
        attributes.add(new Attribute("health", "Сомочувствие", AttributeType.MultilineText));
        attributes.add(new Attribute("allergy", "Аллергия (описание)", AttributeType.MultilineText));
        attributes.add(new Attribute("diarrhea", "Понос (описание)", AttributeType.MultilineText));
        attributes.add(new Attribute("constipation", "Запор (описание)", AttributeType.MultilineText));
        attributes.add(new Attribute("feces", "Кал", AttributeType.MultilineText));
        attributes.add(new Attribute("urine", "Моча", AttributeType.MultilineText));
        attributes.add(new Attribute("injury", "Травма", AttributeType.MultilineText));
        attributes.add(new Attribute("cut", "Порез", AttributeType.MultilineText));
        attributes.add(new Attribute("burn", "Ожег", AttributeType.MultilineText));
        attributes.add(new Attribute("taking medicine", "Прием лекаства (название)",
                AttributeType.Text, "Доза", AttributeType.Double));
    }

}
