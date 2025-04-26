package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public final class  StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        //addValidation("required", StringUtils::isNoneEmpty);
        addValidation("required", StringUtils::isNoneEmpty);
        return this;
    }

    public StringSchema minLength(int minLength) {
        addValidation("minLength", (object) -> object.length() >= minLength);
        return this;
    }

    public StringSchema minLength() {
        addValidation("minLength", (object) -> !object.isEmpty());
        return this;
    }

    public StringSchema contains(String container) {
        addValidation("contains", (object) ->
                object.contains(container)
        );
        return this;
    }


}
