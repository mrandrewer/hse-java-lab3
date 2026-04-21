package ru.hse.lab3;

import java.math.BigDecimal;

/**
 * Лабораторная работа 3. Вариант 15
 */
public class App {

    public static void main(String[] args) {
        ConfectioneryProduct[] products = new ConfectioneryProduct[20];

        products[0] = new ConfectioneryProduct("Конфета", BigDecimal.valueOf(10.0));
        products[1] = new ConfectioneryProduct("Пирожное картошка", BigDecimal.valueOf(125.0));
        products[2] = new Cake("Торт Наполеон", BigDecimal.valueOf(800.0), 5);
        products[3] = new Cake("Торт Медовик", BigDecimal.valueOf(750.0), 7);
        products[4] = new Cake("Торт Прага", BigDecimal.valueOf(900.0), 3);
        products[5] = new Cookie("Овсяное печенье", BigDecimal.valueOf(100.0), Shape.ROUND);
        products[6] = new Cookie("Крекер", BigDecimal.valueOf(70.0), Shape.SQUARE);
        products[7] = new Cookie("Печенье Звездочка", BigDecimal.valueOf(95.0), Shape.STAR);
        products[8] = new Cookie("Печенье Сердечко", BigDecimal.valueOf(80.0), Shape.HEART);
        products[9] = new ChocolateCookie("Шоколадное печенье темное", BigDecimal.valueOf(100.0), Shape.ROUND,
                ChocolateType.DARK);
        products[10] = new ChocolateCookie("Шоколадное печенье молочное", BigDecimal.valueOf(95.0), Shape.STAR,
                ChocolateType.MILK);
        products[11] = new ChocolateCookie("Шоколадное печенье белое", BigDecimal.valueOf(95.0), Shape.SQUARE,
                ChocolateType.WHITE);
        products[12] = new ChocolateCookie("Шоколадное печенье горькое", BigDecimal.valueOf(110.0), Shape.HEART,
                ChocolateType.BITTER);
        products[13] = new ConfectioneryProduct("Мармелад", BigDecimal.valueOf(112.0));
        products[14] = new Cake("Торт Сметанник", BigDecimal.valueOf(780.0), 4);
        products[15] = new Cookie("Печенье Имбирное", BigDecimal.valueOf(122.0), Shape.ROUND);
        products[16] = new ChocolateCookie("Шоколадное печенье с орехами", BigDecimal.valueOf(125.0), Shape.STAR,
                ChocolateType.DARK);
        products[17] = new ConfectioneryProduct("Желе апельсиновое", BigDecimal.valueOf(45.0));
        products[18] = new Cake("Чизкейк Нью-Йорк", BigDecimal.valueOf(1200.0), 2);
        products[19] = new Cookie("Крекер соленый", BigDecimal.valueOf(35.0), Shape.SQUARE);

        // Вывод массива объектов
        System.out.println("Список кондитерских изделий:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
        System.out.println();
    }
}
