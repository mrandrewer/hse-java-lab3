package ru.hse.lab3;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Базовый класс кондитерских изделий
 */
public class ConfectioneryProduct {
    /** Название кондитерского изделия */
    private String name;

    /** Цена изделия */
    private BigDecimal price;

    /**
     * Создает {@link ConfectioneryProduct} с значениями по умолчанию
     * Название устанавливается как "Кондитерское изделие", цена равна 0
     */
    public ConfectioneryProduct() {
        this("Кондитерское изделие", BigDecimal.ZERO);
    }

    /**
     * Создает {@link ConfectioneryProduct} с указанными названием и ценой
     *
     * @param name  название изделия
     * @param price цена изделия
     * @throws IllegalArgumentException если название пустое или цена отрицательная
     */
    public ConfectioneryProduct(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
    }

    /**
     * Возвращает название изделия
     *
     * @return название изделия
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название изделия
     *
     * @param name название изделия
     * @throws IllegalArgumentException если название пустое или null
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    /**
     * Возвращает цену изделия
     *
     * @return цена изделия
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Устанавливает цену изделия
     *
     * @param price цена изделия
     * @throws IllegalArgumentException если цена отрицательная
     */
    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    /**
     * Возвращает строковое представление кондитерского изделия
     *
     * @return строка с названием и ценой изделия
     */
    @Override
    public String toString() {
        return String.format("ConfectioneryProduct{name='%s', price=%.2f}", name, price.doubleValue());
    }

    /**
     * Сравнивает текущее изделие с другим объектом
     *
     * @param obj объект для сравнения
     * @return true, если объекты одного класса и имеют одинаковые название и цену
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfectioneryProduct other)) {
            return false;
        }
        return price.compareTo(other.price) == 0 && Objects.equals(name, other.name);
    }

    /**
     * Возвращает хеш-код изделия.
     *
     * @return хеш-код на основе названия и цены
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
