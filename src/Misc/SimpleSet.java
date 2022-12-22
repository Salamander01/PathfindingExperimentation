package Misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SimpleSet<T> implements Set<T> {
    ArrayList<T> arr = new ArrayList<>();
    
    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return arr.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return arr.iterator();
    }

    @Override
    public Object[] toArray() {
        return arr.toArray();
    }

    @Override
    public boolean add(T o) {
        if (arr.contains(o)) return false;
        arr.add(o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!arr.contains(o)) return false;
        arr.remove(o);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T t : c) {
            if (add(t)) modified = true;
        }
        return modified;
    }

    @Override
    public void clear() {
        arr.clear();
    }

    @Override
    public boolean removeAll(Collection c) {
       return arr.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return arr.retainAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return arr.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return arr.toArray();
    }
}