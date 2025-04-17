package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema required() {
        addValidation("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int sizeMap)  {
        addValidation("sizeof", (object) -> object.size() == sizeMap);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {

        var entries = schemas.entrySet();
        for (var entry : entries) {
            addValidation(entry.getKey(), object -> entry.getValue().isValid(object.toString()));
        }

        return this;
    }
}
