package ru.hse.lab3.confectionery;

/**
 * Перечисление форм печенья
 */
public enum Shape {
    ROUND("Круг"),
    STAR("Звезда"),
    SQUARE("Квадрат"),
    HEART("Сердце");

    private final String displayName;

    Shape(String displayName) {
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
