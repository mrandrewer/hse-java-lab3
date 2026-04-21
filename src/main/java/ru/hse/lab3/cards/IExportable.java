package ru.hse.lab3.cards;

import java.time.LocalDateTime;

/**
 * Интерфейс для карточек, которые могут быть экспортированы
 */
public interface IExportable {
    /**
     * Получить уникальный идентификатор объекта
     *
     * @return идентификатор
     */
    String getId();

    /**
     * Получить дату создания объекта
     *
     * @return дата создания
     */
    LocalDateTime getCreationDate();

    /**
     * Получить строку описания объекта
     *
     * @return строка описания
     */
    String getDigest();

    /**
     * Получить содержимое объекта
     *
     * @return строка с содержимым
     */
    String getContents();

}
