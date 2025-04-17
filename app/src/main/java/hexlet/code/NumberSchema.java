package hexlet.code;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Number> {

    public NumberSchema required() {
        addValidation("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addValidation("positive(", (object) -> (int) object >= 0);
        return this;
    }

    public NumberSchema range(int beginning, int end) {
        addValidation("range", (object) -> (beginning <= (int) object) && ((int) object <= end));
        return this;
    }
}
