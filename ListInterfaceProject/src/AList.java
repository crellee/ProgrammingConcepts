import java.util.Arrays;

/**
 * Created by christianhasselstrom on 15/05/2016.
 */
public class AList<T> implements ListInterface<T>
{
    private T[] list; // array of list entries
    private int numberOfEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;
    public AList()
    {
        this(DEFAULT_INITIAL_CAPACITY);
    }
    public AList(int initialCapacity)
    {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempList = (T[])new Object[initialCapacity];
        list = tempList;
    }
    @Override
    public void add(T newEntry)
    {
        ensureCapacity();
        list[numberOfEntries] = newEntry;
        numberOfEntries++;
    }
    @Override
    public boolean add(int newPosition, T newEntry)
    {
        boolean isSuccessful = true;
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            ensureCapacity();
            makeRoom(newPosition);
            list[newPosition - 1] = newEntry;
            numberOfEntries++;
        }
        else
            isSuccessful = false;

        return isSuccessful;
    }
    @Override
    public T remove(int givenPosition) {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            assert !isEmpty();
            result = list[givenPosition - 1];
            if (givenPosition < numberOfEntries)
                removeGap(givenPosition);
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public void clear()
    {
        list = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++)
        {
            if (anEntry.equals(list[index]))
            {
                found = true;
            }
        }
        return found;
    }

    @Override
    public int getLength()
    {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return getLength() == 0;
    }

    @Override
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index];
        } // end for
        return result;
    }

    @Override
    public void giveT(ListInterface<T> newEntry) {

    }

    private void ensureCapacity() {
        if (numberOfEntries == list.length)
            list = Arrays.copyOf(list, 2 * list.length);
    }

    private void makeRoom(int newPosition)
    {
        assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = lastIndex; index >= newIndex; index--)
            list[index + 1] = list[index];
    }

    private void removeGap(int givenPosition)
    {
        assert (givenPosition >= 1) && (givenPosition < numberOfEntries);
        int removedIndex = givenPosition - 1; int lastIndex = numberOfEntries - 1;
        for (int index = removedIndex; index < lastIndex; index++) list[index] = list[index + 1];
    }

}
