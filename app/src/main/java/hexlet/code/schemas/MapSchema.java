package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema required() {
        addValidation("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int sizeMap) {
        addValidation("sizeof", (object) ->
                ((Object) object != null) && (object.size() == sizeMap)
        );
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        Predicate<Map<String, String>> shapePredicate = map -> schemas.entrySet().stream()
                .allMatch(entry -> entry.getValue().isValid((T) map.get(entry.getKey())));
        addValidation("shape", shapePredicate);
        return this;
    }
}
