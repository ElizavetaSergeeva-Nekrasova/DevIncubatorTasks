package by.incubator.task13;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    private Object[] arrayOfElements;
    private int size;
    private int capacity = DEFAULT_CAPACITY;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.arrayOfElements = new Object[capacity];
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
    public void add(int index, T element) {
        if ((double)size / (double) capacity < 0.7) {
            addElement(index, element);
        } else {
            capacity = ((capacity * 3) / 2) + 1;

            Object[] newArray = createNewArray();
            fillNewArray(newArray);
            arrayOfElements = newArray;

            addElement(index, element);
        }
    }

    @Override
    public boolean add(T t) {
        add(size, t);

        return true;
    }

    @Override
    public T get(int index) {
        return (T) arrayOfElements[index];
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public T remove(int index) {
        T element = get(index);

        removeElement(index);

        return element;
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

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < arrayOfElements.length; i++) {
            if (arrayOfElements[i].equals(o)) {
                remove(i);
            }
        }

        return true;
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

    private void addElement(int index, T element) {
        moveElementsToRight(index);
        arrayOfElements[index] = element;
        size++;
    }

    private void removeElement(int index) {
        moveElementsToLeft(index);
        size--;
    }

    private Object[] createNewArray() {
        Object[] newArray = new Object[capacity];

        return newArray;
    }

    private void fillNewArray(Object[] newArray) {
        for (int i = 0; i < size; i++) {
            newArray[i] = arrayOfElements[i];
        }
    }

    private void moveElementsToRight(int index) {
        for (int i = size - 1; i >= index; i--) {
            arrayOfElements[i + 1] = arrayOfElements[i];
        }
    }

    private void moveElementsToLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            arrayOfElements[i] = arrayOfElements[i + 1];
        }
    }
}