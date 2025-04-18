package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NumberSchemaTest {
    private Validator v;
    private NumberSchema schema;

    @BeforeEach
    void init() {
        v = new Validator();
        schema = v.number();
    }

    @Test
    void required() {
        assertTrue(schema.required().isValid(10));
        assertTrue(schema.required().isValid(0));
        assertTrue(schema.required().isValid(-10));
        assertFalse(schema.required().isValid(null));
    }

    @Test
    void positive() {
        assertTrue(schema.positive().isValid(10));
        assertFalse(schema.positive().isValid(-10));
        assertFalse(schema.positive().isValid(null));
    }

    @Test
    void range() {
        assertTrue(schema.range(5, 20).isValid(10));
        assertTrue(schema.range(5, 20).isValid(5));
        assertTrue(schema.range(5, 20).isValid(20));
        assertFalse(schema.range(5, 20).isValid(25));
        assertFalse(schema.range(5, 20).isValid(4));
        assertFalse(schema.range(5, 20).isValid(null));
    }

    @Test
    void complexNumberTest() {
        assertTrue(schema.required().positive().range(5, 20).isValid(10));
        assertFalse(schema.required().positive().range(5, 20).isValid(21));
        assertFalse(schema.required().positive().range(5, 20).isValid(4));
        assertFalse(schema.positive().range(5, 20).isValid(null));
    }
}
