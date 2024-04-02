package Task1;

import java.util.NoSuchElementException;

public class MyOptional<T> {
     T t = null;

    private MyOptional(T value) {
        this.t = value;
    }

    public static <T> MyOptional of(T value) {
        MyOptional<T> optional = new MyOptional<T>(value);
        return optional;
    }

    public boolean isPresent() {
        return this.t != null;
    }

    public T get() {
        try {
            return this.t;
        } catch (NoSuchElementException e) {
            return (T) new NoSuchElementException(e);
        }
    }

}