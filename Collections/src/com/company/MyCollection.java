package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {

    private int size;

    private Object[] elementData = new Object[10];

    /**
     *
     */
    @Override
    public boolean add(final E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
        }
        elementData[size++] = e;
        return true;
    }

    /**
     *
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     *
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    /**
     *
     */
    @Override
    public boolean contains(final Object o) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     *
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(final T[] a) {
        T[] result;
        if (a.length < size) {
            result = (T[]) (Arrays.copyOf(elementData, size));
        } else {
            System.arraycopy(elementData, 0, a, 0, size);
            result = a;
        }
        return result;
    }

    /**
     *
     */
    @Override
    public boolean remove(final Object o) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                result = true;
                System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                size--;
                break;
            }
        }
        return result;
    }

    /**
     *
     */
    @Override
    public boolean containsAll(final Collection<?> c) {
        boolean result = true;
        for (Object o : c) {
            if (!contains(o)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     *
     */
    @Override
    public boolean addAll(final Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    /**
     *
     */
    @Override
    public boolean removeAll(final Collection<?> c) {
        boolean result = false;
        for (Object o : c) {
            if (remove(o)) {
                result = true;
            }
        }
        return result;
    }

    /**
     *
     */
    @Override
    public boolean retainAll(final Collection<?> c) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            boolean isThere = false;
            for (Object o : c) {
                if (o.equals(elementData[i])) {
                    isThere = true;                 //не использую c.contains,
                    break;
                }                                   //потому что запрещено использовать готовые реализации
            }
            if (!isThere) {
                remove(elementData[i]);
                i--;
                result = true;
            }
        }
        return result;
    }

    /**
     *
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    private class MyIterator<T> implements Iterator<T> {

        private int cursor = 0;
        private boolean canRemove = false;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            canRemove = true;
            return (T) elementData[cursor++];
        }

        @Override
        public void remove() {
            if (canRemove) {
                System.arraycopy(elementData, cursor, elementData, cursor - 1, size - cursor);
                size--;
                elementData[size] = null;
                cursor--;
                canRemove = false;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}