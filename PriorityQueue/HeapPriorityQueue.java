package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected ArrayList<Entry<K, V>> heap;

    public HeapPriorityQueue() {
        super();
        heap = new ArrayList<>();
    }

    public HeapPriorityQueue(Comparator<K> customComparator) {
        super(customComparator);
        heap = new ArrayList<>();
    }

    public int size() {
        return heap.size();
    }

    public Entry<K, V> min() {
        if (isEmpty())
            return null;
        return heap.get(0);
    }

    private int left(int j) {
        return (2 * j) + 1;
    }

    private int right(int j) {
        return (2 * j) + 2;
    }

    private int parent(int j) {
        if (j != 0)
            return (j - 1) / 2;
        return 0;
    }

    private Entry<K, V> createEntry(K key, V value) {
        return new Entry<K, V>(key, value, heap.size());
    }

    private boolean canContinueUpHeapBubble(Entry<K, V> parent, Entry<K, V> newEntry) {
        return !parent.equals(newEntry) && compare(parent, newEntry) > 0;
    }

    private void downHeapBubble(Entry<K, V> newEntry) {
        while (canContinueDownHeapBubble(newEntry)) {
            swap(newEntry, getMinChild(heap.get(left(newEntry.getIndex())), heap.get(right(newEntry.getIndex()))));
        }
    }

    private Entry<K, V> getMinChild(Entry<K, V> left, Entry<K, V> right) {
        if (compare(left, right) <= 0)
            return left;
        return right;
    }

    private boolean canContinueDownHeapBubble(Entry<K, V> newEntry) {
        int leftIndex = left(newEntry.getIndex());
        int rightIndex = right(newEntry.getIndex());
        if (leftIndex >= heap.size() || rightIndex >= heap.size())
            return false;
        Entry<K, V> left = heap.get(leftIndex);
        Entry<K, V> right = heap.get(rightIndex);
        return left.getIndex() < heap.size() && right.getIndex() < heap.size()
                && compare(newEntry, getMinChild(left, right)) > 0;
    }

    private Entry<K, V> removeAndSetRoot(Entry<K, V> entry) {
        Entry<K, V> originalRoot = heap.get(0);
        heap.set(0, heap.remove(entry.getIndex()));
        heap.get(0).setIndex(0);
        return originalRoot;
    }

    private void upHeapBubble(Entry<K, V> newEntry) {
        Entry<K, V> parent = heap.get(parent(newEntry.getIndex()));
        while (canContinueUpHeapBubble(parent, newEntry)) {
            swap(parent, newEntry);
            parent = heap.get(parent(newEntry.getIndex()));
        }
    }

    private void swap(Entry<K, V> entry1, Entry<K, V> entry2) {
        int tempIndex1 = entry1.getIndex();
        int tempIndex2 = entry2.getIndex();
        heap.set(tempIndex1, entry2);
        heap.set(tempIndex2, entry1);
        entry1.setIndex(tempIndex2);
        entry2.setIndex(tempIndex1);
    }

    public void replaceValue(Entry<K, V> entry, V value) {
        entry.setValue(value);
    }

    public void replaceKey(Entry<K, V> entry, K key) {
        entry.setKey(key);
        upHeapBubble(entry);
        downHeapBubble(entry);
    }

    public void insert(K key, V value) throws IllegalArgumentException {
        super.checkKey(key);
        Entry<K, V> newEntry = createEntry(key, value);
        heap.add(newEntry);
        upHeapBubble(newEntry);
    }

    public Entry<K, V> removeMin() {
        if (isEmpty())
            return null;
        Entry<K, V> minEntry = removeAndSetRoot(heap.get(heap.size() - 1));
        downHeapBubble(heap.get(0));
        return minEntry;
    }

    public void showQueue() {
        System.out.println("Showing priority queue status");
        System.out.println();
        for (int i = 0; i < heap.size(); i++) {
            System.out.print("Key: " + heap.get(i).getKey() + " Value: " + heap.get(i).getValue() + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        HeapPriorityQueue<Integer, Integer> heapPriorityQueue = new HeapPriorityQueue<Integer, Integer>();
        heapPriorityQueue.insert(2, 2);
        heapPriorityQueue.insert(3, 3);
        heapPriorityQueue.showQueue();
        heapPriorityQueue.insert(1, 1);
        heapPriorityQueue.showQueue();
        System.out.println(
                "Min:" + "Key: " + heapPriorityQueue.min().getKey() + " Value: " + heapPriorityQueue.min().getValue()
                        + " ");
        heapPriorityQueue.insert(10, 10);
        heapPriorityQueue.insert(6, 6);
        heapPriorityQueue.insert(4, 4);
        heapPriorityQueue.showQueue();
        heapPriorityQueue.insert(1, 0);
        heapPriorityQueue.showQueue();
        heapPriorityQueue.removeMin();
        heapPriorityQueue.showQueue();
    }
}
