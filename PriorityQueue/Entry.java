package PriorityQueue;

public class Entry<K, V> {
    private K key;
    private V entry;
    private int index;

    public Entry(K key, V entry, int index) {
        this.key = key;
        this.entry = entry;
        this.index = index;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.entry;
    }

    public int getIndex() {
        return this.index;
    }

    public void setKey(K newKey) {
        this.key = newKey;
    }

    public void setValue(V newValue) {
        this.entry = newValue;
    }

    public void setIndex(int newIndex) {
        this.index = newIndex;
    }
}
