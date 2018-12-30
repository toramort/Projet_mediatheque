package dataObjects;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public class Morceaux implements SortedSet<String> {
    @Override
    public Comparator<? super String> comparator() {
        return null;
    }

    @Override
    public SortedSet<String> subSet(String fromElement, String toElement) {
        return null;
    }

    @Override
    public SortedSet<String> headSet(String toElement) {
        return null;
    }

    @Override
    public SortedSet<String> tailSet(String fromElement) {
        return null;
    }

    @Override
    public String first() {
        return null;
    }

    @Override
    public String last() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        return false;
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
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
