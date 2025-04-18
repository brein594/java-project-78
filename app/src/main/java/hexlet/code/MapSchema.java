package hexlet.code;

import hexlet.code.schemas.BaseSchema;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema required() {
        addValidation("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int sizeMap) {
        addValidation("sizeof", (object) -> {
            if ((Object) object == null) {
                return false;
            }
            return object.size() == sizeMap;
        });
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {

        Predicate<Map<String, String>> shapePredicate = map -> schemas.keySet().stream()
                .allMatch(key -> schemas.get(key).isValid((T) map.get(key)));

        addValidation("shape", shapePredicate);

        return this;
    }
}
