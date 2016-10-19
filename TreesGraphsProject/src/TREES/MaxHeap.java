package TREES; /**
 * Created by christianhasselstrom on 01/05/2016.
 */

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
    private T[] heap; // array af heapets forskellige entries
    private int lastIndex; // index af sidste entry
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public MaxHeap()
    {
        this(DEFAULT_INITIAL_CAPACITY);
    }


    public MaxHeap(int initialCapacity)
    {
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Comparable[initialCapacity + 1]; heap = tempHeap;
        lastIndex = 0;
    } // end constructor



    public void add(T newEntry)
    {
        lastIndex++;
        int newIndex = lastIndex;
        int parentIndex = newIndex / 2;
        while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
        {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        } // end while
        heap[newIndex] = newEntry;
    }




    public T removeMax() {
        T root = null;
        if (!isEmpty())
        {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);

        }
        return root;
    }

    public T getMax()
    {
        T root = null; if (!isEmpty())
            root = heap[1]; return root;
    } // end getMax

    public boolean isEmpty()
    {
        return lastIndex < 1;
    } // end isEmpty

    public int getSize()
    {
        return lastIndex;
    } // end getSize

    public void clear()
    {
        for (; lastIndex > -1; lastIndex--) heap[lastIndex] = null;
        lastIndex = 0;
    } // end clear



    public MaxHeap(T[] entries) {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Comparable[entries.length + 1];
        heap = tempHeap;
        lastIndex = entries.length;
        // copy given array to data field
        for (int index = 0; index < entries.length; index++) heap[index + 1] = entries[index];
        // create heap
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--) reheap(rootIndex);
    }

    public void reheap(int rootIndex)
    {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;

        while (!done && (leftChildIndex <= lastIndex) ) {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if ( (rightChildIndex <= lastIndex) &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
            {
                largerChildIndex = rightChildIndex;
            }
            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else
                done = true;
        } // end while
        heap[rootIndex] = orphan;
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] array, int n)
    {

    }





} // end MaxHeap

