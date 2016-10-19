package DEQUE;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by christianhasselstrom on 19/05/2016.
 */
public class DequeTest
{
    public static void main(String[] args)
    {
        Deque<Integer> deque = new LinkedList();


        int array2[] =
                {
                        50,40,30,20,10
                };

        for(int i = 0; i < array2.length; i++)
        {
            deque.addFirst(array2[i]);
        }
        System.out.println("Deque: " + deque);
        System.out.println("First: " + deque.getFirst());
        System.out.println("Last: " + deque.getLast());
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque: " + deque);
    }
}
