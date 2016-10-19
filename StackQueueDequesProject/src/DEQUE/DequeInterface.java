package DEQUE;

/**
 * Created by christianhasselstrom on 18/05/2016.
 */
public interface DequeInterface<T>
{
    public void addFirst(T newEntry);

    public void addLast(T newEntry);

    public T removeFirst();

    public T removeLast();

    public T getFirst();

    public T getLast();

    public boolean isEmpty();

    public void clear();
}
