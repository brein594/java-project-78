package hexlet.code;

public class NumberSchema extends BaseSchema<Number> {

    public NumberSchema required() {
        addValidation("required", (object) -> !(object == null));
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
