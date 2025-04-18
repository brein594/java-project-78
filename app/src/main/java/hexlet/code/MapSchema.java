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

        Predicate<Map<String, String>> shapePredicate = map -> schemas.keySet().stream()
                        .allMatch( key -> schemas.get(key).isValid(map.get(key)));

        addValidation( "shape", shapePredicate);

        return this;
    }
}
