package ru.hse.lab3;

import ru.hse.lab3.cards.DocumentStatus;
import ru.hse.lab3.cards.IExportable;
import ru.hse.lab3.cards.documents.Contract;
import ru.hse.lab3.cards.documents.Document;
import ru.hse.lab3.confectionery.Cake;
import ru.hse.lab3.confectionery.ChocolateCookie;
import ru.hse.lab3.confectionery.ChocolateType;
import ru.hse.lab3.confectionery.Cookie;
import ru.hse.lab3.confectionery.ConfectioneryProduct;
import ru.hse.lab3.confectionery.Shape;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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

    /**
     * Тестирование работы с кондитерскими изделиями
     */
    public static void testConfectionary() {
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

    /**
     * Создание массива карточек, реализующих IExportable
     * 
     * @return массив IExportable
     */
    public static IExportable[] createExportableCards() {
        return new IExportable[] {
                new Contract(
                        UUID.randomUUID(),
                        "Договор аудита финансовой отчетности",
                        "Договор на проведение аудита финансовой отчетности за 2025 год",
                        "Д-2026-01",
                        LocalDate.of(2026, 1, 15),
                        "ООО Курьянов и партнеры",
                        BigDecimal.valueOf(185000),
                        DocumentStatus.ACTIVE,
                        LocalDate.of(2026, 2, 1),
                        LocalDate.of(2027, 3, 31)),
                new Document(
                        UUID.randomUUID(),
                        "Счёт на оплату услуг по договору Д-2026-01",
                        "Аванс по договору Д-2026-01",
                        "С-12344/8",
                        LocalDate.of(2026, 3, 15),
                        "Оплата за проведение аудита финансовой отчетности за 2025 год по договору Д-2026-01",
                        DocumentStatus.ARCHIVE),
                new Document(
                        UUID.randomUUID(),
                        "Счёт на оплату услуг по договору Д-2026-01",
                        "Итоговый расчет по договору Д-2026-01",
                        "С-12344/9",
                        LocalDate.of(2026, 3, 15),
                        "Оплата за проведение аудита финансовой отчетности за 2025 год по договору Д-2026-01",
                        DocumentStatus.APPROVAL),
                new Contract(
                        UUID.randomUUID(),
                        "Договор технического обслуживания",
                        "Договор технического обслуживания оборудования головнго офиса на 2026 год",
                        "ТО-2026-2",
                        LocalDate.of(2025, 12, 26),
                        "ООО ТехСервис",
                        BigDecimal.valueOf(1250000),
                        DocumentStatus.ACTIVE,
                        LocalDate.of(2026, 1, 1),
                        LocalDate.of(2026, 12, 31)),
                new Document(
                        UUID.randomUUID(),
                        "Акт по договору ТО-2026-2",
                        "Акт выполненных работ за явнарь 2026 года",
                        "АКТ-ТО-2026-2-01",
                        LocalDate.of(2026, 2, 6),
                        "Перечень выполненных работ по договору ТО-2026-2 за январь 2026 года ...",
                        DocumentStatus.SIGNING)
        };
    }

    /**
     * Экранирование специальных символов в строке для корректного формата JSON
     * 
     * @param value исходная строка
     * @return строка с экранированными символами
     */
    private static String escapeJson(String value) {
        return value.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    /**
     * Преобразование объекта, реализующего IExportable, в JSON строку
     * 
     * @param item объект, реализующий IExportable
     * @return строка в формате JSON
     */
    private static String exportableToJson(IExportable item) {
        return String.format("{" +
                "\"id\":\"%s\"," +
                "\"creationDate\":\"%s\"," +
                "\"digest\":\"%s\"," +
                "\"contents\":\"%s\"}",
                escapeJson(item.getId()),
                item.getCreationDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                escapeJson(item.getDigest()),
                escapeJson(item.getContents()));
    }

    /**
     * Сохранение массива IExportable объектов в JSON массив строк
     * 
     * @param exportables массив объектов, реализующих IExportable
     * @return строка в формате JSON
     */
    public static String saveExportablesToJsonArray(IExportable[] exportables) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < exportables.length; i++) {
            builder.append(exportableToJson(exportables[i]));
            if (i < exportables.length - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * Тестирование экспорта карточек в JSON
     */
    public static void testCardExportToJson() {
        IExportable[] cards = createExportableCards();
        String jsonArray = saveExportablesToJsonArray(cards);
        System.out.println("JSON массив карточек:");
        System.out.println(jsonArray);
        System.out.println();
    }

    public static void main(String[] args) {
        testConfectionary();
        testCardExportToJson();
    }
}
