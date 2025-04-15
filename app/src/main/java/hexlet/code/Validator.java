package hexlet.code;

public class Validator extends BaseSchema<Object> {
    public StringSchema string() {
        return new StringSchema();
    }
}
