package ru.hse.lab3;

import ru.hse.lab3.confectionery.Cake;
import ru.hse.lab3.confectionery.ChocolateCookie;
import ru.hse.lab3.confectionery.ChocolateType;
import ru.hse.lab3.confectionery.Cookie;
import ru.hse.lab3.confectionery.ConfectioneryProduct;
import ru.hse.lab3.confectionery.Shape;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Лабораторная работа 3. Вариант 15
 */
public class App {

    /**
     * Заполнение набора кондитерских изделий
     * 
     * @return Массив {@link ConfectioneryProduct}
     */
    private static ConfectioneryProduct[] fillArray() {
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

        return products;
    }

    /**
     * Вычисление среднего количества слоёв во всех тортах
     */
    public static double getAverageLayersInCakes(ConfectioneryProduct[] products) {
        int totalLayers = 0;
        int cakeCount = 0;
        for (ConfectioneryProduct product : products) {
            if (product instanceof Cake cake) {
                totalLayers += cake.getLayers();
                cakeCount++;
            }
        }
        return cakeCount > 0 ? (double) totalLayers / cakeCount : 0.0;
    }

    /**
     * Получение названий всех видов шоколадного печенья заданной формы
     */
    public static List<String> getChocolateCookieNamesByShape(ConfectioneryProduct[] products, Shape shape) {
        List<String> names = new ArrayList<>();
        for (ConfectioneryProduct product : products) {
            if (product instanceof ChocolateCookie сookie) {
                if (сookie.getShape() == shape) {
                    names.add(сookie.getName());
                }
            }
        }
        return names;
    }

    /**
     * Получение общей стоимости всех кондитерских изделий
     */
    public static BigDecimal getTotalPrice(ConfectioneryProduct[] products) {
        BigDecimal total = BigDecimal.ZERO;
        for (ConfectioneryProduct product : products) {
            total = total.add(product.getPrice());
        }
        return total;
    }

    /**
     * Получение количества печенья каждого типа формы
     */
    public static HashMap<Shape, Integer> getCookieCountByShape(ConfectioneryProduct[] products) {
        var result = new HashMap<Shape, Integer>();
        for (ConfectioneryProduct product : products) {
            if (product instanceof Cookie cookie) {
                Shape shape = cookie.getShape();
                result.put(shape, result.getOrDefault(shape, 0) + 1);
            }
        }
        return result;
    }

    /**
     * Получение cамого дорогого изделия
     */
    public static ConfectioneryProduct getMostExpensiveProduct(ConfectioneryProduct[] products) {
        ConfectioneryProduct mostExpensive = null;
        for (ConfectioneryProduct product : products) {
            if (mostExpensive == null || product.getPrice().compareTo(mostExpensive.getPrice()) > 0) {
                mostExpensive = product;
            }
        }
        return mostExpensive;
    }

    public static void main(String[] args) {
        var products = fillArray();

        // Вывод массива объектов
        System.out.println("Список кондитерских изделий:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
        System.out.println();

        // Выполнение запросов
        System.out.println("Запросы:");

        double avgLayers = getAverageLayersInCakes(products);
        System.out.println("Среднее количество слоёв во всех тортах: " + avgLayers);

        List<String> roundChocoCookies = getChocolateCookieNamesByShape(products, Shape.ROUND);
        System.out.println("Названия шоколадного печенья круглой формы: " + roundChocoCookies);

        BigDecimal totalPrice = getTotalPrice(products);
        System.out.println("Общая стоимость всех изделий: " + totalPrice + " руб.");

        HashMap<Shape, Integer> shapeCounts = getCookieCountByShape(products);
        System.out.println("Количество печенья по формам:");
        for (var entry : shapeCounts.entrySet()) {
            System.out.println("   " + entry.getKey().getDisplayName() + ": " + entry.getValue());
        }

        ConfectioneryProduct mostExpensive = getMostExpensiveProduct(products);
        System.out.println("Самое дорогое изделие: " + mostExpensive);
    }
}
