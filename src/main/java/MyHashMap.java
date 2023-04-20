import java.util.Arrays;

public class MyHashMap<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private Entry<K, V>[] entries;

    private Integer size;

    public MyHashMap() {
        this(2);
    }

    public MyHashMap(int arrayLength) {
        this.entries = new Entry[arrayLength];
        this.size = 0;
    }

    public V put(K key, V value) {
        makeNewDataIfNotEnough();
        if (containsKey(key)) {
            entries[indexOf(key)].value = value;
            return value;
        }
        entries[size++] = new Entry(key, value);
        return value;
    }

    public Integer size() {
        return size;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].key.equals(key)) {
                return (V) entries[i].value;
            }
        }
        return null;
    }

    public void makeNewDataIfNotEnough() {
        if (ifNotEnough()) {
            makeNewData();
        }
    }
    private void makeNewData() {
        Entry<K, V>[] newEntries = new Entry[entries.length * 2];
        System.arraycopy(entries, 0, newEntries, 0, entries.length);
        entries = newEntries;
    }
    private boolean ifNotEnough() {
        return size == entries.length-1;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < size; i++) {
            if (entries[i].value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public V remove(K key) {
        if (containsKey(key)) {
            int index = indexOf(key);
            V targetValue = (V) entries[index].value;
            for (int i = index; i < size-1; i++) {
                entries[i].key = entries[i + 1].key;
                entries[i].value = entries[i + 1].value;
            }
            size--;
            return targetValue;
        }
        return null;
    }

    public void clear() {
        Arrays.fill(entries, null);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
