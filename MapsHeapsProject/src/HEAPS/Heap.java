package HEAPS;

import javax.xml.crypto.Data;

/**
 * Created by christianhasselstrom on 29/05/2016.
 */
public class Heap
{
    private int maxSize;

    private int itemsInArray = 0;
    private Data[] theHeap; //indeholder vores keys/items


    public Data pop()
    {
         if (itemsInArray != 0)
         {
             int tempItemsInArray = itemsInArray - 1;
             Data root = theHeap[0];
             theHeap[0] = theHeap[--itemsInArray];
             return root;
         }
        return null;
    }

    public void heapTheArray(int i)
    {

    }
}
