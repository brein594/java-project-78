package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        addValidation("required", StringUtils::isNotEmpty);
    }

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        addValidation("minLength", (object) -> object.length() >= minLength);
        return this;
    }

    public StringSchema minLength() {
        return minLength(1);
    }

    public StringSchema contains(String container) {
        addValidation("contains", (object) ->
                object.contains(container)
        );
        return this;
    }
}
