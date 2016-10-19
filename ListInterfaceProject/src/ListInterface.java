/**
 * Created by christianhasselstrom on 15/05/2016.
 */
public interface ListInterface<T>
{
    public void add(T newEntry);

    public boolean add(int newPosition, T newEntry);

    public T remove(int givenPosition);

    public void clear();

    public boolean contains(T anEntry);

    public int getLength();

    public boolean isEmpty();

    public T[] toArray();

    public void giveT(ListInterface<T> newEntry);
}
