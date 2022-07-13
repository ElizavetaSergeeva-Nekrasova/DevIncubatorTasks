package by.incubator.task14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
    Node<K, V>[] table;
    private int size;
    private int capacity;
    private double loadFactor;
    private double threshold = capacity * loadFactor;
    private final int DEFAULT_CAPACITY = 16;
    private final double DEFAULT_LOAD_FACTOR = 0.75;

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
        int hash = hash(key);
        int indexFor = indexFor(hash, capacity);

        putElement(key, value, hash, indexFor);

        return value;
    }

    @Override
    public V remove(Object key) {
        int hash = hash(key);
        int index = indexFor(hash, capacity);

        if (table[index] == null) {
            return null;
        }

        Node nodeToRemove = removeIfExists((K) key, hash, index);

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

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int indexFor(int hash, int capacity) {
        return hash & (capacity - 1);
    }

    private void putElement(K key, V value, int hash, int index) {

        if (table[index] == null) {
            table[index] = createNode(key, value, hash, null);
            size++;
            return;
        }

        if (putIfExists(key, value, hash, index)) {
            return;
        }

        table[index] = createNode(key, value, hash, table[index]);
        size++;
    }

    private Node createNode(K key, V value, int hash, Node next) {
        return new Node<>(key, hash, value, next);
    }

    private boolean putIfExists(K key, V value, int hash, int index) {
        if (getNodeInList(key, hash, index) == null) {
            return false;
        }

        getNodeInList(key, hash, index).value = value;
        return true;
    }

    private Node removeIfExists(K key, int hash, int index) {
        Node node = table[index];

        if (node.HASH == hash && node.KEY.equals(key)) {
            table[index] = node.next;
            return node;
        }

        while (node.next != null) {
            if ((node.next.HASH == hash) && (node.next.KEY.equals(key))) {
                Node nodeToRemove = node.next;
                node.next = node.next.next;
                return nodeToRemove;
            }

            node = node.next;
        }

        return null;
    }

    private Node getNodeInList(K key, int hash, int index) {
        Node node = table[index];

        while (node != null) {
            if (node.HASH == hash && node.KEY.equals(key)) {
                    return node;
            }
            node = node.next;
        }
        return null;
    }

    private Node getNode(K key, int hash) {
        int index = indexFor(hash, capacity);

        if (table[index] == null) {
            return null;
        }

        return getNodeInList(key, hash, index);
    }
}