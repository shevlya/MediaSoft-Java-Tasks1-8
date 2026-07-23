package lambda;

import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTests {
    public static void runAll(){
        Printable p = () -> System.out.println("Печать через лямбда");
        p.print();

        Predicate<String> notNull = s -> s != null;
        Predicate<String> notEmpty = s -> !s.isEmpty();
        Predicate<String> valid = notNull.and(notEmpty);
        System.out.println("Проверка строки: " + valid.test("Hello"));

        Predicate<String> startWithJorN = s -> s.startsWith("J") || s.startsWith("N");
        Predicate<String>endWithA = s -> s.endsWith("A");
        Predicate<String> fullCheck = startWithJorN.and(endWithA);
        System.out.println("Java ok? " + fullCheck.test("Java"));

        Consumer<HeavyBox> ship = box -> System.out.println("Отгрузили ящик с весом: " + box.getWeight());
        Consumer<HeavyBox> send = box -> System.out.println("Отправляем ящик с весом: " + box.getWeight());
        ship.andThen(send).accept(new HeavyBox(17));

        Function<Integer, String> checkSign = i -> i == 0 ? "Ноль" :(i > 0 ? "Положительное" : "Отрицательное");
        System.out.println("Число: " + checkSign.apply(-7));

        Supplier<Integer> random = () -> (int) (Math.random() * 11);
        System.out.println("Случайное число: " + random.get());
    }
}
