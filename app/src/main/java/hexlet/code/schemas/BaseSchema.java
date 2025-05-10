package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> validations = new HashMap<>();

    protected final void addValidation(String name, Predicate<T> validation) {
        validations.put(name, validation);
    }

    public boolean checkRequired(T ob ) {
        return true;
    }

    public final boolean isValid(T object) {
        boolean result = true;
        if (object == null || (boolean) object.equals("")) {
            if (validations.containsKey("required")) {
                return false;
            } //else {
                //result = true;
                /*
                result = validations.entrySet().stream()
                //.filter(entry -> !entry.getKey().equals("required") )
                .allMatch(value -> {
                    try {
                        return value.getValue().test(null);
                    } catch (NullPointerException e) {
                        return false;
                    }
                });

                 */
           // }
        } //else {
            result = validations.entrySet().stream()
                    .filter(entry -> !entry.getKey().equals("required"))
                    .allMatch(value -> {
                        try {
                            return value.getValue().test(object);
                        } catch (NullPointerException e) {
                            return false;
                        }
                    });
        //}
        return result;
    }
}
