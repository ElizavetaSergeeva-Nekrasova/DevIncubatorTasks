package by.incubator.task14;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
    private Node<K, V>[] table;
    private int size;
    private int capacity;
    private double loadFactor;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    public MyHashMap() {
        capacity = DEFAULT_CAPACITY;
        loadFactor = DEFAULT_LOAD_FACTOR;
        table = new Node[capacity];
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final K KEY;
        final int HASH;
        V value;
        Node<K, V> next;

        public Node(K KEY, int HASH, V value, Node<K, V> next) {
            this.KEY = KEY;
            this.HASH = HASH;
            this.value = value;
            this.next = next;
        }

        @Override
        public final K getKey() {
            return KEY;
        }

        @Override
        public final V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K, V> node;
        return (node = getNode((K) key, hash(key))) == null ? null : node.value;
    }

    @Override
    public V put(K key, V value) {
        double threshold = capacity * loadFactor;

        if (size >= threshold) {
            increaseAndRefillTable();
        }

        int hash = hash(key);
        int indexFor = indexFor(hash, capacity);

        return putElement(key, value, hash, indexFor);
    }

    @Override
    public V remove(Object key) {
        int hash = hash(key);
        int index = indexFor(hash, capacity);

        if (table[index] == null) {
            return null;
        }

        Node<K, V> nodeToRemove = removeIfExists((K) key, hash, index);

        if (nodeToRemove == null) {
            return null;
        }

        size--;

        return (V) nodeToRemove.value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public V getOrDefault(Object key, V defaultValue) {
        Node<K, V> node;
        return (node = getNode((K) key, hash(key))) == null ? defaultValue : node.value;
    }

    private static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private static int indexFor(int hash, int capacity) {
        return hash & (capacity - 1);
    }

    private V putElement(K key, V value, int hash, int index) {

        if (table[index] == null) {
            table[index] = createNode(key, value, hash, null);
            size++;
            return null;
        }

        V previousValue = putIfExists(key, value, hash, index);
        if (previousValue != null) {
            return previousValue;
        }

        table[index] = createNode(key, value, hash, table[index]);
        size++;
        return null;
    }

    private Node<K, V> createNode(K key, V value, int hash, Node<K, V> next) {
        return new Node<K, V>(key, hash, value, next);
    }

    private V putIfExists(K key, V value, int hash, int index) {
        Node<K, V> node = getNodeInList(key, hash, index);
        if (node == null) {
            return null;
        }

        V previousValue = node.value;
        node.value = value;
        return previousValue;
    }

    private Node<K, V> removeIfExists(K key, int hash, int index) {
        Node<K, V> node = table[index];

        if (node.HASH == hash && node.KEY.equals(key)) {
            table[index] = node.next;
            return node;
        }

        while (node.next != null) {
            if ((node.next.HASH == hash) && (node.next.KEY.equals(key))) {
                Node<K, V> nodeToRemove = node.next;
                node.next = node.next.next;
                return nodeToRemove;
            }

            node = node.next;
        }

        return null;
    }

    private Node<K, V> getNodeInList(K key, int hash, int index) {
        Node<K, V> node = table[index];

        while (node != null) {
            if (node.HASH == hash && node.KEY.equals(key)) {
                    return node;
            }
            node = node.next;
        }
        return null;
    }

    private Node<K, V> getNode(K key, int hash) {
        int index = indexFor(hash, capacity);

        if (table[index] == null) {
            return null;
        }

        return getNodeInList(key, hash, index);
    }

    private void increaseAndRefillTable() {
        capacity = capacity * 2;

        Node<K, V>[] oldTable = table;
        Node<K, V>[] newTable = new Node[capacity];
        table = newTable;

        refillTable(oldTable);
    }

    private void refillTable(Node<K, V>[] oldTable) {
        size = 0;
        for (int i = 0; i < oldTable.length; i++) {
            refillBucket(oldTable, i);
        }
    }

    private void refillBucket(Node<K, V>[] oldTable, int i) {
        Node<K, V> node = oldTable[i];

        while (node != null) {
            put(node.getKey(), node.getValue());
            node = node.next;
        }
    }
}