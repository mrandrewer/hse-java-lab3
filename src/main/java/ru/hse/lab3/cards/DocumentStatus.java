package ru.hse.lab3.cards;

/**
 * Перечисление статусов документа
 */
public enum DocumentStatus {
    DRAFT("Черновик"),
    APPROVAL("Согласование"),
    CORRECTION("Корректировка"),
    SIGNING("Подписание"),
    ACTIVE("Активный"),
    ARCHIVE("Архивный");

    private final String displayName;

    DocumentStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
