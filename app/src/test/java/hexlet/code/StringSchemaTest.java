package hexlet.code;

//import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {
    private final StringSchema schema = new StringSchema();

    @Test
    void requiredTest() {
        assertTrue(schema.required().isValid("Hello"));
        assertFalse(schema.required().isValid(""));
        assertFalse(schema.required().isValid(null));
    }

    @Test
    void minLengthTest() {
        assertTrue(schema.minLength(5).isValid("Hello"));
        assertTrue(schema.minLength().isValid("Hello"));
        assertFalse(schema.minLength(5).isValid("He"));
    }

    @Test
    void containsTest() {
        assertTrue(schema.contains("He").isValid("Hello"));
        assertTrue(schema.contains("").isValid("Hello"));
        assertFalse(schema.contains("Hee").isValid("Hello"));
    }
}
