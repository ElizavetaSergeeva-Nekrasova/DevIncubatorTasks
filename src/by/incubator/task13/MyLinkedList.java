package by.incubator.task13;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {
    private Node head = null;
    private Node tail = null;
    private int size;

    public MyLinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, head, null);
        head.next = tail;
    }

    private static class Node<T> {
        private Node next;
        private Node prev;
        private T value;

        public Node(Node next, Node prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head.next == tail;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        addBefore(tail, t);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        Node node = getNode(index);

        return (T) node.value;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        Node node = getNode(index);
        addBefore(node, element);
    }

    @Override
    public T remove(int index) {
        Node node = getNode(index);

        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;

        return (T) node.value;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private Node getNode(int index) {

        Node walkingNode = head.next;

        for (int i = 0; i < index; i++) {
            walkingNode = walkingNode.next;
        }

        return walkingNode;
    }

    private void addBefore(Node beforeWhich, T value) {
        Node lastNode = beforeWhich.prev;
        Node node = new Node(beforeWhich, lastNode, value);
        lastNode.next = node;
        beforeWhich.prev = node;

        size++;
    }
}