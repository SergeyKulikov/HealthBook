package com.mycoloruniverse.health.presenter;

import com.mycoloruniverse.health.Settings;
import com.mycoloruniverse.health.model.VisualEventBased;
import com.mycoloruniverse.health.model.VisualInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Данный файл предназначен для хранения всех интерфейсов событий и похожих по функионалу.
 * возможно его следует вывести на сервер, тогда можно будет обновлять при подключении к интернету
 * без одновления приложения.
 */

public class VisualInterfaceList {
    private static VisualInterfaceList instance;
    private final Map<String, VisualInterface> visualInterfaceMap = new HashMap<>();

    public static VisualInterfaceList getInstance() {
        if (instance == null) {
            instance = new VisualInterfaceList();
        }
        return instance;
    }

    private VisualInterfaceList() {

        // интерфейсы ввода данных по событиям
        createTemperatureMeasurement();
        createTakingMedicine();
        createWellBeing();

        // интерфейс человека/пациента (member)
        createMember();



    }


    public void put(String interfaceName, VisualInterface visualInterface) {
        visualInterfaceMap.put(interfaceName, visualInterface);
    }

    public VisualInterface get(String interfaceName) {
        if (visualInterfaceMap.containsKey(interfaceName)) {
            return visualInterfaceMap.get(interfaceName);
        }
        return new VisualInterface();
    }

    protected void createTemperatureMeasurement() {
        // Измерение температуры
        VisualInterface visualInterface = new VisualInterface();
        visualInterface.addItem("", // пустая группа, поэтому ввкладки создаваться не будут
                new VisualEventBased("ABECCC1F-22F4-4601-B024-A1A0552241B9",
                        "Измерение температоры",
                        null,
                        null,
                        "Введите температору",
                        Settings.Decimal)
        );

        this.put("temperature measurement", visualInterface);
    }

    protected void createTakingMedicine() {
        VisualInterface visualInterface = new VisualInterface();
        visualInterface.addItem("",
                new VisualEventBased("14C752BB-1D3C-4D46-8678-652964F5F021",
                        "Название лекарства",
                        null,
                        null,
                        "Введите название",
                        Settings.Text)
        );
        visualInterface.addItem("",
                new VisualEventBased("45A225A4-D022-4BA3-B530-6FF3D73F2662",
                        "Дозировка",
                        null,
                        null,
                        "",
                        Settings.Integer)
        );
        // TODO: добавить единицу измерения. Или не добавить. Подумать.
        this.put("drugs-name", visualInterface);
    }

    protected void createWellBeing() {
        VisualInterface visualInterface = new VisualInterface();
        visualInterface.addItem("",
                new VisualEventBased("3AAA9404-2313-4C77-B8B8-3E692144C9B1",
                        "Сомочуствие",
                        null,
                        null,
                        "Введите подробное описание",
                        Settings.MultilineText)
        );
        this.put("well-being", visualInterface);
    }

    protected void createMember() {
        VisualInterface visualInterface = new VisualInterface();

        visualInterface.addItem("",
                new VisualEventBased("8F9BCE45-8D38-44AE-B713-659C41811E1B",
                        "Фамилия",
                        null,
                        null,
                        "фамилия",
                        Settings.Text)
        );
        visualInterface.addItem("",
                new VisualEventBased("877D30BE-27EC-4DDF-9F39-1F9B127B825F",
                        "Имя",
                        null,
                        null,
                        "имя",
                        Settings.Text)
        );
        visualInterface.addItem("",
                new VisualEventBased("BC548C7C-EA45-4926-8DDB-2B9B670B00CE",
                        "Отчество",
                        null,
                        null,
                        "отчество",
                        Settings.Text)
        );
        visualInterface.addItem("",
                new VisualEventBased("gender", "Пол", Settings.SingleSelect)
                        .addParameter("Муж").addParameter("Жен")
        );
        visualInterface.addItem("",
                new VisualEventBased("E035FA2B-F215-4947-B662-9CFEF76C73D3",
                        "Дата рождения",
                        null,
                        null,
                        "введите дату рождения",
                        Settings.Date)
        );
        this.put("member", visualInterface);
    }


}
