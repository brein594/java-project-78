package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private Map<String, Predicate<T>> validations = new HashMap<>();

    protected void addValidation(String name, Predicate<T> validation) {
        validations.put(name, validation);
    }

    public boolean isValid(T object) {
       return validations.values().stream()
                .allMatch( value -> value.test(object));
    }

}
