public class MyHashMap<T, T1> {
    String[] keyData = new String[2];
    Integer[] valueData = new Integer[2];
    Integer size = 0;

    public Integer put(String key, Integer value) {
        makeNewDataIfNotEnough();
        if (containsKey(key)) {
            valueData[indexOf(key)] = value;
            return 1;
        }
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

    public void makeNewDataIfNotEnough() {
        if (ifNotEnough()) {
            makeNewData();
        }
    }
    private void makeNewData() {
        String[] newKeyData = new String[keyData.length * 2];
        Integer[] newValueData = new Integer[valueData.length * 2];
        System.arraycopy(keyData, 0, newKeyData, 0, keyData.length);
        System.arraycopy(valueData, 0, newValueData, 0, valueData.length);
        keyData = newKeyData;
        valueData = newValueData;
    }
    private boolean ifNotEnough() {
        return size == keyData.length-1;
    }

    private Integer indexOf(String key) {
        for (int i = 0; i < size; i++) {
            if (keyData[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(String key) {
        for (int i = 0; i < size; i++) {
            if (keyData[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Integer value) {
        for (int i = 0; i < size; i++) {
            if (valueData[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public Integer remove(String key) {
        if (containsKey(key)) {
            int index = indexOf(key);
            Integer targetValue = valueData[index];
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
}
