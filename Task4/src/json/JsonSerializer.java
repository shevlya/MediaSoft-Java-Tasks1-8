package json;

import annotations.JsonField;
import java.lang.reflect.Field;

public class JsonSerializer {
    public static String toJson(Object ob){
        StringBuilder sb = new StringBuilder("{");
        Field[] fields = ob.getClass().getDeclaredFields();
        boolean first = true;
        for(Field field : fields){
            if(field.isAnnotationPresent(JsonField.class)){
                field.setAccessible(true);
                try{
                    Object value = field.get(ob);
                    String jsonName = field.getAnnotation(JsonField.class).name();
                    if(!first) sb.append(", ");
                    sb.append("\"").append(jsonName).append("\": ").append("\"").append(value).append("\"");
                    first = false;
                }catch (IllegalArgumentException | IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
