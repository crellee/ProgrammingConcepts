package GRAPHS.ADT_Package;

/**
 * Created by christianhasselstrom on 01/05/2016.
 */
public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; // references the first node in the chain

    @Override
    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    } // end push

    @Override
    public T pop()
    {
        T top = peek();
        if (topNode != null)
            topNode = topNode.getNextNode();
        return top;
    } // end pop

    @Override
    public T peek()
    {
        T top = null;
        if (topNode != null)
            top = topNode.getData();
        return top;
    }

    @Override
    public boolean isEmpty()
    {
        return topNode == null;
    } // end isEmpty

    @Override
    public void clear()
    {
        topNode = null;
    } // end clear

    private class Node
    {
        private T data; // entry in stack
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
} // end LinkedStack
