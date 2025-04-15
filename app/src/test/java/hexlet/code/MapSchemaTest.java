package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapSchemaTest {
    private final MapSchema schema = new MapSchema();
    private HashMap<String, String> map1 = new HashMap<>(Map.of("key1", "value1", "key2", "value2"));
    private HashMap<String, String> map2 = new HashMap<>(Map.of("key1", null, "key2", "value2"));

    @Test
    void requiredTest() {
        assertTrue(schema.required().isValid(map1));
        //assertFalse(schema.required().isValid(map2));
    }
/*
    @Test
    void sizeofTest() {
        assertTrue(schema.sizeof(2).isValid(map1));
        assertFalse(schema.sizeof(3).isValid(map1));
    }

 */
}