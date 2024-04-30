package Task1;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SortedListSet<T extends Comparable<T>> extends LinkedList<T> implements SortedSet<T> {

    private Comparator<T> comparator;

    public SortedListSet(){
    }
    public SortedListSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public boolean add(T o){
        if(!this.contains(o)){
            super.add(o);
            this.sort(comparator);
            return true;
        }
        return false;
    }

    @Override
    public T first() {
        return this.get(0);
    }

    @Override
    public T last() {
        return this.get(this.size()-1);
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        Integer ok = 0;
        SortedListSet<T> newSet = new SortedListSet<T>();
        for(T o: this){
            if(o == fromElement){
                ok = 1;
            }
            if(ok == 1){
                newSet.add((T) o);
            }
            if(o == toElement){
                ok = 0;
            }
        }
        return newSet;
    }

    @Override
    public SortedListSet<T> reversed(){
        Collections.reverse(this);
        return this;
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        SortedListSet<T> newSet = new SortedListSet<T>();

        for(T o:this){
            if(o == toElement){
                break;
            }
            newSet.add(o);
        }
        return newSet;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        SortedListSet<T> newSet = new SortedListSet<T>();
        SortedListSet<T> actualSet = this.reversed();
        for(T o:this){
            if(o == fromElement){
                break;
            }
            newSet.add(o);
        }
        return newSet;
    }
    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        super.sort(c);
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return super.toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return super.removeIf(filter);
    }

    @Override
    public Stream<T> stream() {
        return super.stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return super.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        super.forEach(action);
    }
}
