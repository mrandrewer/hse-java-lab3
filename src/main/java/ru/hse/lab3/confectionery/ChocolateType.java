package ru.hse.lab3.confectionery;

/**
 * Перечисление типов шоколада
 */
public enum ChocolateType {
    WHITE("Белый"),
    MILK("Молочный"),
    DARK("Темный"),
    BITTER("Горький");

    private final String displayName;

    ChocolateType(String displayName) {
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
