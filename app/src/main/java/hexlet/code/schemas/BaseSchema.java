package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> validations = new HashMap<>();

    protected final void addValidation(String name, Predicate<T> validation) {
        validations.put(name, validation);
    }

    public final boolean isValid(T object) {
        boolean result;
        if (object == null) {
            result = validations.getOrDefault("required", value -> true).test(null);
        }

        try {
            result = validations.values().stream()
                    .allMatch(value -> value.test(object));
        } catch (NullPointerException e) {
            return false;
        }
        return result;
    }
}
