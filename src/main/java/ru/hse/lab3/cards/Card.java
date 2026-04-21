package ru.hse.lab3.cards;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

/**
 * Базовый класс для всех элементов системы электронного документооборота
 */
public abstract class Card implements IExportable {

    /** Уникальный идентификатор карточки */
    private UUID id = UUID.randomUUID();

    /** Название карточки */
    private String title;

    /** Описание карточки */
    private String description;

    /** Статус карточки */
    private DocumentStatus status;

    /** Дата создания */
    private LocalDateTime creationDate;

    /** Формат даты и времени карточки */
    protected static final DateTimeFormatter DOC_DATE_FORMATTER;

    /** Статический инициализатор */
    static {
        DOC_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    }
    /** Инициализатор экземпляра */
    {
        status = DocumentStatus.DRAFT;
        creationDate = LocalDateTime.now();
    }

    /**
     * Конструктор без параметров.
     */
    public Card() {
        this("Проект карточки", "Описание карточки");
    }

    /**
     * Конструктор с названием и описанием.
     *
     * @param title       название карточки
     * @param description описание карточки
     */
    public Card(String title, String description) {
        setTitle(title);
        setDescription(description);
    }

    /**
     * Конструктор с названием, описанием и статусом.
     *
     * @param title       название карточки
     * @param description описание карточки
     * @param status      статус карточки
     */
    public Card(String title, String description, DocumentStatus status) {
        this(title, description);
        setStatus(status);
    }

    /**
     * Конструктор с названием, описанием и статусом.
     *
     * @param title        название карточки
     * @param description  описание карточки
     * @param status       статус карточки
     * @param creationDate дата создания карточки
     */
    public Card(String title, String description, DocumentStatus status, LocalDateTime creationDate) {
        this(title, description, status);
        this.creationDate = creationDate;
    }

    /**
     * Получить идентификатор карточки
     *
     * @return идентификатор
     */
    public final String getId() {
        return id.toString();
    }

    /**
     * Получить название карточки
     *
     * @return название
     */
    public String getTitle() {
        return title;
    }

    /**
     * Установить название карточки
     *
     * @param title название
     */
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        this.title = title;
    }

    /**
     * Получить описание карточки
     *
     * @return описание
     */
    public String getDescription() {
        return description;
    }

    /**
     * Установить описание карточки
     *
     * @param description описание
     */
    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be blank.");
        }
        this.description = description;
    }

    /**
     * Получить статус карточки
     *
     * @return статус
     */
    public DocumentStatus getStatus() {
        return status;
    }

    /**
     * Установить статус карточки
     *
     * @param status статус
     */
    public void setStatus(DocumentStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null.");
        }
        this.status = status;
    }

    /**
     * Получить дату создания карточки
     *
     * @return дата в формате строки
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Получить дату создания карточки
     *
     * @return дата в формате строки
     */
    public String getFormattedCreationDate() {
        return creationDate.format(DOC_DATE_FORMATTER);
    }

    @Override
    public String getDigest() {
        return String.format("Карточка: %s от: %s", title, getFormattedCreationDate());
    }

    @Override
    public abstract String getContents();

    /**
     * Получить строковое представление карточки.
     *
     * @return строка с информацией о карточке
     */
    @Override
    public String toString() {
        return String.format("Card{id='%s', title='%s', status='%s', created=%s}",
                id, title, status.getDisplayName(), getFormattedCreationDate());
    }

    /**
     * Сравнить две карточки.
     *
     * @param obj объект для сравнения
     * @return true, если карточки имеют одинаковый ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card other)) {
            return false;
        }
        return Objects.equals(id, other.id);
    }

    /**
     * Получить хеш-код карточки.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
