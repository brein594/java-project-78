package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NumberSchemaTest {
    private final NumberSchema schema = new NumberSchema();

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
    }

    @Test
    void range() {
        assertTrue(schema.range(5, 20).isValid(10));
        assertTrue(schema.range(5, 20).isValid(5));
        assertTrue(schema.range(5, 20).isValid(20));
        assertFalse(schema.range(5, 20).isValid(25));
        assertFalse(schema.range(5, 20).isValid(4));
    }
}
