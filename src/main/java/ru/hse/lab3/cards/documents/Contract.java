package ru.hse.lab3.cards.documents;

import ru.hse.lab3.cards.DocumentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Класс, представляющий договор в системе электронного документооборота.
 * Наследуется от Document.
 */
public class Contract extends Document {

    /** Дата начала действия договора */
    private LocalDate startDate;

    /** Дата окончания действия договора */
    private LocalDate endDate;

    /** Сторона договора */
    private String counterparty;

    /** Сумма договора */
    private BigDecimal amount;

    /**
     * Конструктор с названием и описанием.
     *
     * @param id          идентификатор договора
     * @param title       название договора
     * @param description описание договора
     */
    public Contract(UUID id, String title, String description) {
        super(id, title, description);
    }

    /**
     * Конструктор с названием, описанием и статусом.
     *
     * @param id          идентификатор договора
     * @param title       название договора
     * @param description описание договора
     * @param status      статус договора
     */
    public Contract(UUID id, String title, String description, DocumentStatus status) {
        super(id, title, description, status);
    }

    /**
     * Конструктор со всеми параметрами договора.
     *
     * @param id          идентификатор договора
     * @param title       название договора
     * @param description описание договора
     * @param status      статус договора
     * @param amount      сумма договора
     * @param startDate   дата начала
     * @param endDate     дата окончания
     */
    public Contract(UUID id, String title, String description, DocumentStatus status, BigDecimal amount,
            LocalDate startDate, LocalDate endDate) {
        super(id, title, description, status);
        setAmount(amount);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    /**
     * Получить сумму договора.
     *
     * @return сумма договора
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Установить сумму договора.
     *
     * @param amount сумма договора
     */
    public void setAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Contract amount cannot be null or negative.");
        }
        this.amount = amount;
    }

    /**
     * Установить сумму договора.
     * Перегруженный метод.
     *
     * @param amount сумма договора
     */
    public void setAmount(double amount) {
        setAmount(BigDecimal.valueOf(amount));
    }

    /**
     * Получить дату начала действия договора.
     *
     * @return дата начала
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Установить дату начала действия договора.
     *
     * @param startDate дата начала
     */
    public void setStartDate(LocalDate startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date cannot be null.");
        }
        if (endDate != null && !startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }
        this.startDate = startDate;
    }

    /**
     * Получить дату окончания действия договора.
     *
     * @return дата окончания
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Установить дату окончания действия договора.
     *
     * @param endDate дата окончания
     */
    public void setEndDate(LocalDate endDate) {
        if (endDate == null) {
            throw new IllegalArgumentException("End date cannot be null.");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }
        this.endDate = endDate;
    }

    /**
     * Получить сторону договора (контрагента).
     *
     * @return название контрагента
     */
    public String getCounterparty() {
        return counterparty;
    }

    /**
     * Установить сторону договора (контрагента).
     *
     * @param counterparty название контрагента
     */
    public void setCounterparty(String counterparty) {
        if (counterparty == null || counterparty.isBlank()) {
            throw new IllegalArgumentException("Counterparty name cannot be blank.");
        }
        this.counterparty = counterparty;
    }

    /**
     * Проверить, активен ли договор в текущий момент
     *
     * @return true, если договор активен
     */
    public boolean isActive() {
        LocalDate today = LocalDate.now();
        return !today.isBefore(startDate) && !today.isAfter(endDate);
    }

    /**
     * Получить количество дней действия договора
     *
     * @return количество дней
     */
    public long getDurationDays() {
        return java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * Получить строковое представление договора.
     *
     * @return строка с информацией о договоре
     */
    @Override
    public String toString() {
        return String.format("Contract{id='%s', title='%s', regNumber='%s', counterparty='%s', " +
                "amount=%.2f, startDate=%s, endDate=%s, active=%s, status='%s'}",
                getId(), getTitle(), getRegistrationNumber(), counterparty,
                getAmount(), startDate.format(DATE_FORMATTER), endDate.format(DATE_FORMATTER),
                isActive(), getStatus().getDisplayName());
    }

}
