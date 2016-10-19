package GRAPHS.Classes;

import GRAPHS.Interfaces.VertexInterface;

/**
 * Created by christianhasselstrom on 01/05/2016.
 */
public class UndirectedGraph<T> extends DirectedGraph<T>
{
    public UndirectedGraph()
    {
        super();
    }



    @Override
    public boolean addEdge(T begin, T end, double edgeWeight)
    {
        boolean result = false;

        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ( (beginVertex != null) && (endVertex != null) )
            result = beginVertex.connect(endVertex, edgeWeight) && endVertex.connect(beginVertex, edgeWeight);
        if (result)
            edgeCount++;

        return result;
    }




    public void connectBothWays()
    {

    }
}
