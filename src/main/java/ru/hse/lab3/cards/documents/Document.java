package ru.hse.lab3.cards.documents;

import ru.hse.lab3.cards.Card;
import ru.hse.lab3.cards.DocumentStatus;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Класс, представляющий документ в системе электронного документооборота.
 * Наследуется от Card.
 */
public class Document extends Card {

    /** Регистрационный номер документа */
    private String registrationNumber;

    /** Дата регистрации документа */
    private LocalDate registrationDate;

    /** Содержимое документа */
    private String content;

    {
        // Инициализатор: дополнительные значения для документа
        this.registrationNumber = "REG_" + System.currentTimeMillis();
        this.registrationDate = LocalDate.now();
        this.content = "";
    }

    /**
     * Конструктор с идентификатором, названием и описанием.
     *
     * @param id          идентификатор документа
     * @param title       название документа
     * @param description описание документа
     */
    public Document(UUID id, String title, String description) {
        super(id, title, description);
    }

    /**
     * Конструктор с регистрационными данными.
     *
     * @param id                 идентификатор документа
     * @param title              название документа
     * @param description        описание документа
     * @param registrationNumber регистрационный номер
     * @param registrationDate   дата регистрации
     */
    public Document(UUID id, String title, String description,
            String registrationNumber, LocalDate registrationDate) {
        this(id, title, description);
        setRegistrationNumber(registrationNumber);
        setRegistrationDate(registrationDate);
    }

    /**
     * Конструктор с регистрационными данными, содержимым и статусом.
     *
     * @param id                 идентификатор документа
     * @param title              название документа
     * @param description        описание документа
     * @param registrationNumber регистрационный номер
     * @param registrationDate   дата регистрации
     * @param content            содержимое документа
     * @param status             статус документа
     */
    public Document(UUID id, String title, String description,
            String registrationNumber, LocalDate registrationDate, String content,
            DocumentStatus status) {
        this(id, title, description, registrationNumber, registrationDate);
        setContent(content);
        setStatus(status);
    }

    /**
     * Получить регистрационный номер документа
     *
     * @return регистрационный номер
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Установить регистрационный номер документа
     *
     * @param registrationNumber регистрационный номер
     */
    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isBlank()) {
            throw new IllegalArgumentException("Registration number cannot be blank.");
        }
        this.registrationNumber = registrationNumber;
    }

    /**
     * Получить дату регистрации документа
     *
     * @return дата регистрации
     */
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Установить дату регистрации документа
     *
     * @param registrationDate дата регистрации
     */
    public void setRegistrationDate(LocalDate registrationDate) {
        if (registrationDate == null) {
            throw new IllegalArgumentException("Registration date cannot be null.");
        }
        this.registrationDate = registrationDate;
    }

    /**
     * Получить содержимое документа
     *
     * @return содержимое
     */
    public String getContent() {
        return content;
    }

    /**
     * Установить содержимое документа
     *
     * @param content содержимое
     */
    public void setContent(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Document content cannot be blank.");
        }
        this.content = content;
    }

    /**
     * Получить строку описания объекта
     *
     * @return строка с кратким описанием документа
     */
    @Override
    public String getDigest() {
        return String.format("Документ: %s от %s | Рег. номер: %s от %s",
                getTitle(),
                getFormattedCreationDate(),
                registrationNumber,
                registrationDate.format(DATE_FORMATTER));
    }

    /**
     * Получить содержимое объекта
     *
     * @return строка с содержимым документа
     */
    @Override
    public String getContents() {
        return content;
    }

    /**
     * Получить строковое представление документа
     *
     * @return строка с информацией о документе
     */
    @Override
    public String toString() {
        return String.format("Document{id='%s', title='%s', regNumber='%s', regDate=%s, status='%s'}",
                getId(),
                getTitle(),
                registrationNumber,
                registrationDate.format(DATE_FORMATTER),
                getStatus().getDisplayName());
    }

}
