import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class MyHashMapTest {
    private MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    void testPut() {
        assertNull(map.put("Key1", 1));
        assertThat(map.size()).isEqualTo(1);
    }

    @Test
    void testSize() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);
        assertThat(map.size()).isEqualTo(3);
    }

    @Test
    void testGet() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertThat(map.get("Key1")).isEqualTo(1);
        assertThat(map.get("Key2")).isEqualTo(2);
    }

//    @Test
//    void testPutReplace() {
//        map.put("Key1", 1);
//        assertThat(Integer.valueOf(1), map.put("Key1", 2));
//        assertEquals(1, map.size());
//    }

//    @Test
//    void testRemove() {
//        map.put("Key1", 1);
//        map.put("Key2", 2);
//        assertEquals(Integer.valueOf(1), map.remove("Key1"));
//        assertNull(map.remove("Key3"));
//        assertEquals(1, map.size());
//    }
//

//    @Test
//    void testContainsKey() {
//        map.put("Key1", 1);
//        map.put("Key2", 2);
//        assertTrue(map.containsKey("Key1"));
//        assertFalse(map.containsKey("Key3"));
//    }
//
//    @Test
//    void testContainsValue() {
//        map.put("Key1", 1);
//        map.put("Key2", 2);
//        assertTrue(map.containsValue(1));
//        assertFalse(map.containsValue(3));
//    }
//
//    @Test
//    void testClear() {
//        map.put("Key1", 1);
//        map.put("Key2", 2);
//        map.put("Key3", 3);
//        map.clear();
//        assertEquals(0, map.size());
//        assertTrue(map.isEmpty());
//    }
}