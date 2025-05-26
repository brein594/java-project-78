package hexlet.code;


import hexlet.code.schemas.StringSchema;

public class App {


    public static void main(String[] args) {
        var v = new Validator();
        System.out.println(v.getClass());
        var schema = v.string();

        System.out.println(schema.getClass().getName());

        if (schema.getClass().getName().equals("hexlet.code.schemas.StringSchema")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        if (schema instanceof StringSchema) {
            System.out.println("yes StringSchema");
        } else {
            System.out.println("no StringSchema");
        }

    }
}
