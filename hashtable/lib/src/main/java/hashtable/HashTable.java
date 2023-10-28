package hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private Entry<K, V>[] table;
    private int size;

    public HashTable() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public void set(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if ((double) size / table.length >= LOAD_FACTOR_THRESHOLD) {
            resizeTable();
        }

        int index = findIndex(key);

        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            size++;
        } else {
            table[index].setValue(value);
        }
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = findIndex(key);
        if (table[index] != null) {
            return table[index].getValue();
        }
        return null;
    }

    public boolean has(K key) {
        return get(key) != null;
    }

    public Iterable<K> keys() {
        List<K> keys = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    protected int getTableSize() {
        return table.length;
    }

    protected int hash(K key) {
        return key.hashCode() % table.length;
    }

    private int findIndex(K key) {
        int index = hash(key);

        while (table[index] != null && !table[index].getKey().equals(key)) {
            index = (index + 1) % table.length;
        }

        return index;
    }

    private void resizeTable() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                set(entry.getKey(), entry.getValue());
            }
        }
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
