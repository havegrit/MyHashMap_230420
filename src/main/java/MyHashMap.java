import java.util.Arrays;

public class MyHashMap<K, V> {
    K[] keyData;
    V[] valueData;
    Integer size;

    public MyHashMap() {
        this.keyData = (K[]) new Object[2];
        this.valueData = (V[]) new Object[2];
        this.size = 0;
    }

    public V put(K key, V value) {
        makeNewDataIfNotEnough();
        if (containsKey(key)) {
            valueData[indexOf(key)] = value;
            return value;
        }
        keyData[size] = key;
        valueData[size++] = value;
        return value;
    }

    public Integer size() {
        return size;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyData[i].equals(key)) {
                return valueData[i];
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
        K[] newKeyData = (K[]) new Object[keyData.length * 2];
        V[] newValueData = (V[]) new Object[valueData.length * 2];
        System.arraycopy(keyData, 0, newKeyData, 0, keyData.length);
        System.arraycopy(valueData, 0, newValueData, 0, valueData.length);
        keyData = newKeyData;
        valueData = newValueData;
    }
    private boolean ifNotEnough() {
        return size == keyData.length-1;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keyData[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keyData[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < size; i++) {
            if (valueData[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public V remove(K key) {
        if (containsKey(key)) {
            int index = indexOf(key);
            V targetValue = valueData[index];
            for (int i = index; i < size-1; i++) {
                keyData[i] = keyData[i + 1];
                valueData[i] = valueData[i + 1];
            }
            keyData[size-1] = null;
            valueData[size-1] = null;
            size--;
            return targetValue;
        }
        return null;
    }

    public void clear() {
        Arrays.fill(keyData, null);
        Arrays.fill(valueData, null);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
