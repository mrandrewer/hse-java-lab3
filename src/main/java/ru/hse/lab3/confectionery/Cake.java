package ru.hse.lab3.confectionery;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Класс, представляющий торт
 */
public class Cake extends ConfectioneryProduct {
    /** Число слоев торта */
    private int layers;

    /**
     * Создает {@link Cake} с названием "Торт", ценой 0 и одним слоем
     */
    public Cake() {
        this("Торт", BigDecimal.ZERO, 1);
    }

    /**
     * Создает торт с указанным названием, ценой и количеством слоев
     *
     * @param name   название торта
     * @param price  цена торта
     * @param layers количество слоев
     * @throws IllegalArgumentException если layers меньше или равно нулю
     */
    public Cake(String name, BigDecimal price, int layers) {
        super(name, price);
        setLayers(layers);
    }

    /**
     * Возвращает количество слоев торта
     *
     * @return количество слоев
     */
    public int getLayers() {
        return layers;
    }

    /**
     * Устанавливает количество слоев торта
     *
     * @param layers количество слоев
     * @throws IllegalArgumentException если layers меньше или равно нулю
     */
    public void setLayers(int layers) {
        if (layers <= 0) {
            throw new IllegalArgumentException("Number of layers must be positive");
        }
        this.layers = layers;
    }

    /**
     * Возвращает строковое представление торта
     *
     * @return строка с названием, ценой и количеством слоев
     */
    @Override
    public String toString() {
        return String.format("Cake{name='%s', price=%.2f, layers=%d}", getName(), getPrice(), layers);
    }

    /**
     * Сравнивает торт с другим объектом
     *
     * @param obj объект для сравнения
     * @return true, если объект является тортом с теми же свойствами
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cake other)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        return layers == other.layers;
    }

    /**
     * Возвращает хеш-код торта
     *
     * @return хеш-код на основе родительского объекта и количества слоев
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), layers);
    }
}
