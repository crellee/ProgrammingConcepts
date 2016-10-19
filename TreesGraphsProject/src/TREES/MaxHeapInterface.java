package TREES;

/**
 * Created by christianhasselstrom on 01/05/2016.
 */
public interface MaxHeapInterface<T extends Comparable<? super T>>
{
    public void add(T newEntry);
    public T removeMax();
    public T getMax();
    public boolean isEmpty();
    public int getSize();
    public void clear();
}