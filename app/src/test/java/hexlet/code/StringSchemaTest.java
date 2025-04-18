package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {
    private  Validator v;
    private StringSchema schema;

    @BeforeEach
    void init() {
        v = new  Validator();
        schema = v.string();
    }


    @Test
    void stringTest() {
        assertTrue(schema.isValid("Hello"));
        assertTrue(schema.isValid(null));
    }

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
        assertFalse(schema.minLength(5).isValid(null));
    }

    @Test
    void containsTest() {
        assertTrue(schema.contains("He").isValid("Hello"));
        assertTrue(schema.contains("").isValid("Hello"));
        assertFalse(schema.contains("Hee").isValid("Hello"));
        assertFalse(schema.contains("Hee").isValid(null));
    }

    @Test
    void complexStringTest() {
        assertTrue(schema.required().minLength(5).contains("He").isValid("Hello"));
        assertTrue(schema.minLength(100).minLength(5).contains("He").isValid("Hello"));
        assertFalse(schema.required().minLength(5).contains("He").isValid("Hel"));
        assertFalse(schema.required().minLength(5).contains("He").isValid("Hllo"));
        //assertFalse(schema.required().minLength(5).contains("He").isValid(null));
    }

}
