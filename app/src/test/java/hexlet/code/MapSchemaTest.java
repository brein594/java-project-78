package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MapSchemaTest {
    private Validator v;
    private MapSchema schema;
    private static HashMap<String, String> map1;
    private static HashMap<String, String> map2;

    @BeforeAll
    static void initFixture() {
        map1 = new HashMap<>(Map.of("key1", "value1", "key2", "value2"));
        map2 = null;
    }

    @BeforeEach
    void init() {
        v = new Validator();
        schema = v.map();
    }

    @Test
    void requiredTest() {
        assertTrue(schema.required().isValid(map1));
        assertFalse(schema.required().isValid(map2));
    }

    @Test
    void sizeofTest() {
        assertTrue(schema.sizeof(2).isValid(map1));
        assertFalse(schema.sizeof(3).isValid(map1));
        assertFalse(schema.sizeof(3).isValid(map2));
    }


    @Test
    void shapeTest() {
        var v1 = new Validator();
        var schema1 = v1.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        schemas.put("firstName", v1.string().required());
        schemas.put("lastName", v1.string().required().minLength(3));

        schema1.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Bob");

        assertTrue(schema1.sizeof(2).isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "B");
        assertFalse(schema1.sizeof(2).isValid(human2));
    }
}
