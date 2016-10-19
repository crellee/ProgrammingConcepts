package GRAPHS.ADT_Package;

/**
 * Created by christianhasselstrom on 01/05/2016.
 */
public class LinkedQueue<T> implements QueueInterface<T>
{

    private Node firstNode; // references node at front of queue
    private Node lastNode; // references node at back of queue

    public LinkedQueue ()
    {
        firstNode = null;
        lastNode = null;
    } // end default constructor


    public void enqueue (T newEntry)
    {
        Node newNode = new Node (newEntry, null);
        if (isEmpty ())
            firstNode = newNode;
        else
            lastNode.setNextNode (newNode);
        lastNode = newNode;
    } // end enqueue


    public T dequeue ()
    {
        T front = null;
        if (!isEmpty ())
        {
            front = firstNode.getData ();
            firstNode = firstNode.getNextNode ();
            if (firstNode == null)
                lastNode = null;
        } // end if
        return front;
    } // end dequeue

    @Override
    public T getFront()
    {
        return null;
    }


    public boolean isEmpty ()
    {
        return (firstNode == null) && (lastNode == null);
    } // end isEmpty


    public void clear ()
    {
        firstNode = null;
        lastNode = null;
    } // end clear

    private class Node
    {
        private T data; // entry in queue
        private Node next; // link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData()
        {
            return data;
        } // end getData
        private void setData(T newData)
        {
            data = newData;
        } // end setData
        private Node getNextNode()
        {
            return next;
        } // end getNextNode
        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode

    } // end Node
}
