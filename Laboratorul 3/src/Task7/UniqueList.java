package Task7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class UniqueList<T> implements List<T> {

    private final List<T> storage;

    public UniqueList() {

        this.storage = new ArrayList<>();
    }

    @Override
    public String toString() {

        return storage.toString();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public boolean isEmpty() {

        return storage.isEmpty();
    }

    @Override
    public boolean contains(Object o) {

        return storage.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }


    @Override
    public Object[] toArray() {
        return storage.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return storage.toArray(a);
    }


    @Override
    public boolean add(T t) {
        if(!storage.contains(t))
        {
            storage.add(t);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return storage.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return storage.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        List<T> listCopy = new ArrayList<>(c);

        listCopy.removeAll(storage);

        return storage.addAll(index, listCopy);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return storage.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return storage.retainAll(c);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public T get(int index) {
        return storage.get(index);
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= storage.size()) {
            throw new IndexOutOfBoundsException("Indexul este în afara limitelor: " + index);
        }

        if (!storage.contains(element) || storage.indexOf(element) == index) {
            T previousElement = storage.set(index, element);
            return previousElement;
        } else {
            throw new IllegalArgumentException("Elementul duplicat: " + element);
        }
    }

    @Override
    public void add(int index, T element) {
        if (!storage.contains(element)) {
            storage.add(index, element);
        } else {
            throw new IllegalArgumentException("Elementul duplicat: " + element);
        }
    }

    @Override
    public T remove(int index) {
        return storage.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return storage.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return storage.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return storage.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return storage.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return storage.subList(fromIndex, toIndex);
    }
}