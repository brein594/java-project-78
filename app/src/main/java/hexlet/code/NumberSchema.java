package hexlet.code;

import hexlet.code.schemas.BaseSchema;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Number> {

    public NumberSchema required() {
        addValidation("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addValidation("positive", (object) -> {
            if (object == null) {
                return false;
            }
            return (int) object > 0;
        });
        return this;
    }

    public NumberSchema range(int beginning, int end) {
        addValidation("range", (object) -> {
            if (object == null) {
                return false;
            }
            return beginning <= (int) object
                    && ((int) object <= end);
        });
        return this;
    }
}
