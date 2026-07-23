import annotations.DeprecatedEx;
import handlers.DeprecatedHandler;
import json.JsonSerializer;
import lambda.LambdaTests;
import model.Person;

public class Main {
    public static void main(String[] args) {
        System.out.println("Лямбда тесты");
        LambdaTests.runAll();
        System.out.println("Аннотации");
        DeprecatedHandler.process(OldService.class);
        System.out.println("JSON");
        Person person = new Person("Арина", 20);
        System.out.println(JsonSerializer.toJson(person));
    }

    @DeprecatedEx(message = "Use NewService instead")
    class OldService{
        @DeprecatedEx(message = "Use newMethod instead")
        public void oldMethod(){}
        public void newMethod(){}
    }
}