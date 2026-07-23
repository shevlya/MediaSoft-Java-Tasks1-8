package handlers;

import annotations.DeprecatedEx;
import java.lang.reflect.Method;

public class DeprecatedHandler {
    public static void process(Class<?> clss){
       if (clss.isAnnotationPresent(DeprecatedEx.class)){
           System.out.println("Класс " + clss.getSimpleName() + " устарел. Альтернатива: " + clss.getAnnotation(DeprecatedEx.class).message());
       }
       for (Method method : clss.getDeclaredMethods()){
           if(method.isAnnotationPresent(DeprecatedEx.class)){
               System.out.println("Метод " + method.getName() + " устарел. Альтернатива: " + method.getAnnotation(DeprecatedEx.class).message());
           }
       }
    }
}
