package by.bnty.fitr.fusman.labs.lab10.arrays.common;

public interface BaseStorage<T> {
    void remove(T t);

    void remove(int position);

    void add(T t);

    T get(int i);
}
