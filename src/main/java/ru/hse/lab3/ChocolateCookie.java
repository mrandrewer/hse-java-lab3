package ru.hse.lab3;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Класс, представляющий шоколадное печенье
 */
public class ChocolateCookie extends Cookie {
    /** Тип шоколада, используемый в печенье */
    private ChocolateType chocolateType;

    /**
     * Создает шоколадное печенье с названием "Шоколадное печенье", ценой 0.0,
     * круглой формой и темным шоколадом.
     */
    public ChocolateCookie() {
        this("Шоколадное печенье", BigDecimal.ZERO, Shape.ROUND, ChocolateType.DARK);
    }

    /**
     * Создает шоколадное печенье с указанными параметрами
     *
     * @param name          название печенья
     * @param price         цена печенья
     * @param shape         форма печенья
     * @param chocolateType тип шоколада
     * @throws IllegalArgumentException если chocolateType null
     */
    public ChocolateCookie(String name, BigDecimal price, Shape shape, ChocolateType chocolateType) {
        super(name, price, shape);
        setChocolateType(chocolateType);
    }

    /**
     * Возвращает тип шоколада
     *
     * @return тип шоколада
     */
    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    /**
     * Устанавливает тип шоколада
     *
     * @param chocolateType тип шоколада
     * @throws IllegalArgumentException если chocolateType null
     */
    public void setChocolateType(ChocolateType chocolateType) {
        if (chocolateType == null) {
            throw new IllegalArgumentException("Chocolate type cannot be null.");
        }
        this.chocolateType = chocolateType;
    }

    /**
     * Возвращает строковое представление шоколадного печенья.
     *
     * @return строка с названием, ценой, формой и типом шоколада
     */
    @Override
    public String toString() {
        return String.format("ChocolateCookie{name='%s', price=%.2f, shape='%s', chocolateType='%s'}",
                getName(),
                getPrice().doubleValue(),
                getShape().getDisplayName(),
                chocolateType.getDisplayName());
    }

    /**
     * Сравнивает шоколадное печенье с другим объектом
     *
     * @param obj объект для сравнения
     * @return true, если объект является шоколадным печеньем с теми же свойствами
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChocolateCookie other)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        return Objects.equals(chocolateType, other.chocolateType);
    }

    /**
     * Возвращает хеш-код шоколадного печенья
     *
     * @return хеш-код на основе родительского объекта и типа шоколада
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chocolateType);
    }
}
