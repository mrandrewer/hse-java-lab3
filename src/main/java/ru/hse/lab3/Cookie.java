package ru.hse.lab3;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Класс, представляющий печенье
 */
public class Cookie extends ConfectioneryProduct {
    /** Форма печенья */
    private Shape shape;

    /**
     * Создает печенье с названием "Печенье", ценой 0 и круглой формой
     */
    public Cookie() {
        this("Печенье", BigDecimal.ZERO, Shape.ROUND);
    }

    /**
     * Создает печенье с указанным названием, ценой и формой
     *
     * @param name  название печенья
     * @param price цена печенья
     * @param shape форма печенья
     * @throws IllegalArgumentException если форма null
     */
    public Cookie(String name, BigDecimal price, Shape shape) {
        super(name, price);
        setShape(shape);
    }

    /**
     * Возвращает форму печенья
     *
     * @return форма печенья
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * Устанавливает форму печенья
     *
     * @param shape форма печенья
     * @throws IllegalArgumentException если форма null
     */
    public void setShape(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Shape cannot be null.");
        }
        this.shape = shape;
    }

    /**
     * Возвращает строковое представление печенья
     *
     * @return строка с названием, ценой и формой печенья
     */
    @Override
    public String toString() {
        return String.format("Cookie{name='%s', price=%.2f, shape='%s'}",
                getName(),
                getPrice().doubleValue(),
                shape.getDisplayName());
    }

    /**
     * Сравнивает печенье с другим объектом
     *
     * @param obj объект для сравнения
     * @return true, если объект является печеньем с теми же свойствами
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cookie other)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        return Objects.equals(shape, other.shape);
    }

    /**
     * Возвращает хеш-код печенья.
     *
     * @return хеш-код на основе родительского объекта и формы
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shape);
    }
}
