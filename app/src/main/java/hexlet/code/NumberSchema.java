package hexlet.code;

import hexlet.code.schemas.BaseSchema;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addValidation("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addValidation("positive", (object) -> {
            if (object == null) {
                return false;
            }
            return object >= 1;
        });
        return this;
    }

    public NumberSchema range(int beginning, int end) {
        addValidation("range", (object) -> {
            if (object == null) {
                return false;
            }
            return beginning <= object && object <= end;
        });
        return this;
    }
}
