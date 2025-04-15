package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
/*
        var schema = new StringSchema().required().minLength(10);
        System.out.println(schema.isValid("555555"));

        var v = new Validator();
        var schema1 = v.string();

        System.out.println(schema1.isValid(""));

        System.out.println(schema1.isValid(null));
        System.out.println("requir");
        schema1.required();
        System.out.println(schema1.required().isValid(""));
        //System.out.println(schema1.required().isValid(null));
        System.out.println(schema1.isValid("what does the fox say"));
        System.out.println("cont");
        System.out.println(schema1.contains("wh").isValid("what does the fox say"));
        System.out.println(schema1.contains("whatt").isValid("what does the fox say"));
        System.out.println("min");

        var v2 = new Validator();
        var schema2 = v2.string();
        System.out.println(schema2.minLength().isValid("what does the fox say"));
        System.out.println(schema2.minLength(4).minLength(100).isValid("what does the fox say"));
*/
        var schemaM = new MapSchema();
        HashMap<String, String> map1 = new HashMap<>(Map.of("key1", "value1", "key2", "value2"));
        HashMap<String, String> map2 = new HashMap<>(Map.of("key1", null, "key2", "value2"));
        System.out.println(schemaM.isValid(map1));


    }
}
