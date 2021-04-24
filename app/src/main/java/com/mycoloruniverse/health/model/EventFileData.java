package com.mycoloruniverse.health.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


/// !!!! УДАЛИТЬ КЛАСС

/** Это деталики к записеи EventFile
 * В нем хранится события, которые разделены по VisualElement,
 * То есть сли мы хоняем событие "Прием лекарстства", то нам неободимо ввести три значения:
 * название лекартсва, дозу, единицу измерения.
 * Интерфейсом ввода у нас будет VisualInterface с каким-то количеством полей. Эти поля могут быть
 * разделены по вкладкам, но не лодны совпадать по GUID в одном интерфейсе.
 *
 * Для каждого события мы создаем совой уникальный VisualInterface.
 * Выводим на экран поля для ввоода, согласно VisualInterface дяя какого-то конкретного события.
 * Данные полей нужно бы поделить элементы интерфейса и сохраняем в EventFileData, но это гемороно.
 * Пожтому делаю проще: пишу данные всего VisualInterface (или события) одной строкой в виде JSON.
 * Таким образом все становится проще.
 *
 *
 *

 */

@Entity
public class EventFileData {
    @NonNull
    @PrimaryKey
    private String file_event_guid; // Уникальный ключ
    @NonNull
    private String file_guid; // ID файла (родитель)
    private long time; // Время события
}