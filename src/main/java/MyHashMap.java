import java.util.stream.IntStream;

public class MyHashMap<T, T1> {
    String[] keyData = new String[2];
    Integer[] valueData = new Integer[2];
    Integer size = 0;

    public Integer put(String key, Integer value) {
        keyData[size] = key;
        valueData[size++] = value;
        return null;
    }

    public Integer size() {
        return size;
    }

    public Integer get(String key) {
        for (int i = 0; i < size; i++) {
            if (keyData[i].equals(key)) {
                return valueData[i];
            }
        }
        return null;
    }
}
