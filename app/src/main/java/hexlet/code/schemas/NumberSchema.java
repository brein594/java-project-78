package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        addValidation("required", Objects::nonNull);
    }

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        addValidation("positive", (object) -> object == null || object > 0);
        return this;
    }

    public NumberSchema range(int beginning, int end) {
        addValidation("range", (object) -> beginning <= object && object <= end);
        return this;
    }

}
