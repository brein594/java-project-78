package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {
    public MapSchema required() {
        addValidation("required", (object) -> {
            var listValues = object.values().stream()
                    .filter(v -> String.valueOf(v).equals("null"))
                    .findFirst();
            if (listValues.isPresent()) {
                return false;
            } else {
                return true;
            }
        });
        return this;
    }
    /*
    public MapSchema sizeof(int sizeMap)  {
        addValidation("sizeof", (object) -> object.size() = sizeMap);
        return this;
    }

     */

}
