package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.apache.commons.lang3.StringUtils;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addValidation("required", StringUtils::isNoneEmpty);
        return this;
    }

    public StringSchema minLength(int minLength) {
        addValidation("minLength", (object) -> {
            if (!StringUtils.isNoneEmpty(object)) {
                return false;
            }
            return object.length() >= minLength;
        });
        return this;
    }

    public StringSchema minLength() {
        addValidation("minLength", (object) -> {
            if (!StringUtils.isNoneEmpty(object)) {
                return false;
            }
            return !object.isEmpty();
        });
        return this;
    }

    public StringSchema contains(String container) {
        addValidation("contains", (object) -> {
            if (!StringUtils.isNoneEmpty(object)) {
                return false;
            }
            return object.contains(container);
        });
        return this;
    }


}
