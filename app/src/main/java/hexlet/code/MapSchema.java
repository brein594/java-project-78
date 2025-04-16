package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema required() {
        addValidation("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int sizeMap)  {
        addValidation("sizeof", (object) -> object.size() == sizeMap);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        /*
        var entries = schemas.entrySet();
        for (var entry : entries) {
            addValidation(entry.getKey(),isValid(T) );
        }

         */
        return this;
    }
}
