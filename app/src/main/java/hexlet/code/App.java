package hexlet.code;

public class App {
    public static void main(String[] args) {

        var shema = new StringSchema().required().minLength(5);
        System.out.println(shema.isValid("555555"));
    }
}
