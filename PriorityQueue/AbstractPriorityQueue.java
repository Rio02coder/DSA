package PriorityQueue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    private Comparator<K> comparator;

    public AbstractPriorityQueue() {
        comparator = new DefaultComparator<K>();
    }

    public AbstractPriorityQueue(Comparator<K> customComparator) {
        comparator = customComparator;
    }

    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comparator.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) {
        try {
            return comparator.compare(key, key) == 0;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Invalid Key");
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
