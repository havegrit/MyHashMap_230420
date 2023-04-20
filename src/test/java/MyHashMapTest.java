import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("put() 메소드 호출 시, 단순히 사이즈를 증가")
    void testPut() {
        assertNull(map.put("Key1", 1));
        assertThat(map.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("저장 공간 부족 시, 저장 공간 늘리기")
    void testPut_2() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);
        assertThat(map.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("key 데이터로 value 데이터 가져오기")
    void testGet() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertThat(map.get("Key1")).isEqualTo(1);
        assertThat(map.get("Key2")).isEqualTo(2);
    }

    @Test
    @DisplayName("key 데이터 포함 여부 확인")
    void testContainsKey() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertThat(map.containsKey("Key1")).isTrue();
        assertThat(map.containsKey("Key3")).isFalse();
    }

    @Test
    @DisplayName("value 데이터 포함 여부 확인")
    void testContainsValue() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertThat(map.containsValue(1)).isTrue();
        assertThat(map.containsValue(3)).isFalse();
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
//    void testClear() {
//        map.put("Key1", 1);
//        map.put("Key2", 2);
//        map.put("Key3", 3);
//        map.clear();
//        assertEquals(0, map.size());
//        assertTrue(map.isEmpty());
//    }
}