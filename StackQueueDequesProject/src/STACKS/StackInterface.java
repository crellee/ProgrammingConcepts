package STACKS;

/**
 * Created by christianhasselstrom on 18/05/2016.
 */
public interface StackInterface<T>
{
    public void push(T newEntry);

    public T pop();

    public T peek();

    public boolean isEmpty();

    public void clear();
}
