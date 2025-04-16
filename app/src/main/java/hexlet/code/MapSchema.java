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

}
