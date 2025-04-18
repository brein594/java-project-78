package hexlet.code;

import hexlet.code.schemas.BaseSchema;

public final class Validator extends BaseSchema<Object> {
    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }

    public MapSchema map() {
        return new MapSchema();
    }


}
