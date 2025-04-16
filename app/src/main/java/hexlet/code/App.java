package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        var v1 = new Validator();
        var schema1 = v1.string();

        var v2 = new Validator();
        var schema2 = v2.number();

        var v3 = new Validator();
        var schema3 = v3.map();

        System.out.println(schema1.getClass());
        System.out.println(schema2.getClass());
        System.out.println(schema3.getClass());
        System.out.println(v1.getClass());
        System.out.println(v1.toString());
        System.out.println(schema1.toString());


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

    }
}
