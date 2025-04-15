package hexlet.code;

import java.util.Objects;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addValidation("required", (object) -> !(object.toString().isEmpty()) );
        return this;
    }

    public StringSchema minLength(int minLength) {
        addValidation("minLength", (object) -> object.length() >= minLength);
        return this;
    }
    public StringSchema minLength() {
        addValidation("minLength", (object) -> object.toString().length() > 0);
        return this;
    }

    public StringSchema contains(String container) {
        addValidation("contains", (object) -> object.contains(container));
        return this;
    }


}
