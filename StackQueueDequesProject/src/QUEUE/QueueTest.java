package QUEUE;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by christianhasselstrom on 29/05/2016.
 */
public class QueueTest
{
    public static void main(String[] args)
    {
        Queue<String> queue = new LinkedList();


        String array[] =
                {
                        "Queue" , "Stack" , "Deque"
                };
        for(int i = 0; i < array.length; i++)
        {
            queue.offer(array[i]);
        }

        System.out.println("Queue: " + queue);
        queue.poll();
        System.out.println("Queue efter poll: " + queue);
        queue.offer("newItem");
        System.out.println("Queue efter offer: " + queue);
        System.out.println("Queue element: " + queue.element());


    }
}
