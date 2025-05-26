package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> validations = new HashMap<>();
    protected boolean required;

    protected final void addValidation(String name, Predicate<T> validation) {
        validations.put(name, validation);
    }

    protected boolean isEmpty(T object) {
        return !validations.get("required").test(object);
    }

    public final boolean isValid(T object) {
        boolean result = true;
        if (isEmpty(object)) {
            if (required) {
                return false;
            }
        }

        result = validations.entrySet().stream()
                .filter(entry -> !entry.getKey().equals("required"))
                .allMatch(value -> {
                    try {
                        return value.getValue().test(object);
                    } catch (NullPointerException e) {
                        return false;
                    }
                });
        return result;
    }
}
