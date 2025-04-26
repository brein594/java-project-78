package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> validations = new HashMap<>();

    protected final void addValidation(String name, Predicate<T> validation) {
        validations.put(name, validation);
    }

    public final boolean isValid(T object) {
        boolean result = true;
        if (object == null) {
            if (validations.containsKey("required")) {
                return false;
            }
        }

        try {
            result = validations.entrySet().stream()
                    //.filter(entry -> !entry.getKey().equals("required"))
                    .allMatch(value -> value.getValue().test(object));
        } catch (NullPointerException e) {
            return false;
        }
        return result;
    }
}
