package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


class ValidatorTest {
    private Validator v;

    @BeforeEach
    void init() {
        v = new Validator();
    }

    @Nested
    class StringSchemaTest {
        private StringSchema schema;

        @BeforeEach
        void init() {
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
            assertFalse(schema.minLength().isValid(null));
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
        }
    }

    @Nested
    class NumberSchemaTest {
        private NumberSchema schema;

        @BeforeEach
        void init() {
            schema = v.number();
        }

        @Test
        void numberSchemaTest() {
            assertTrue(schema.isValid(10));
            assertTrue(schema.isValid(0));
            assertTrue(schema.isValid(-1));
            assertTrue(schema.isValid(null));
        }

        @Test
        void requiredTest() {
            assertTrue(schema.required().isValid(10));
            assertTrue(schema.required().isValid(0));
            assertTrue(schema.required().isValid(-10));
            assertFalse(schema.required().isValid(null));
        }

        @Test
        void positiveTest() {
            assertTrue(schema.positive().isValid(10));
            assertFalse(schema.positive().isValid(-10));
            assertFalse(schema.positive().isValid(0));
            assertTrue(schema.positive().isValid(null));
        }

        @Test
        void rangeTest() {
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

    @Nested
    class MapSchemaTest {
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

}
