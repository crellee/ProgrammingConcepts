package GRAPHS.Classes;

import GRAPHS.Interfaces.VertexInterface;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by christianhasselstrom on 01/05/2016.
 */
public class Vertex<T> implements VertexInterface<T>
{
    private T label;
    private final LinkedList<Edge> edgeList; // edges to neighbors

    private boolean visited; // true if visited
    private VertexInterface<T> previousVertex; // on path to this vertex
    private double cost; // of path to this vertex

    public Vertex(T vertexLabel)
    {
        label = vertexLabel;
        edgeList = new LinkedList<>();
        visited = false;
        previousVertex = null;
        cost = 0;
    }

    @Override
    public T getLabel()
    {
        return label;
    }

    @Override
    public void visit()
    {
        visited = true;
    }

    @Override
    public void unvisit()
    {
        visited = false;
    }

    @Override
    public boolean isVisited()
    {
        return visited;
    }

    @Override
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
    {
        boolean result = false;
        if (!this.equals(endVertex))
        { // vertices are distinct
            Iterator<VertexInterface<T>> neighbors = this.getNeighborIterator();
            boolean duplicateEdge = false;
            while (!duplicateEdge && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                    duplicateEdge = true;
            } // end while
            if (!duplicateEdge)
            {
                edgeList.add(new Edge(endVertex, edgeWeight));

                result = true;
            } // end if
        } // end if
        return result;
    } // end connect

    @Override
    public boolean connect(VertexInterface<T> endVertex)
    {
        return connect(endVertex, 0);
    } // end connect

    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator()
    {
        //Class is defined below in this class
        return new NeighborIterator();
    }

    @Override
    public Iterator<Double> getWeightIterator()
    {
        //Class is defined below in this class
        return new WeightIterator();
    }

    @Override
    public boolean hasNeighbor()
    {
        return !edgeList.isEmpty();
    }

    @Override
    public VertexInterface<T> getUnvisitedNeighbor()
    {
        VertexInterface<T> result = null;
        Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
        while ((neighbors.hasNext() && (result == null)))
        {
            VertexInterface<T> nextNeighbor = neighbors.next();
            if (!nextNeighbor.isVisited())
                result = nextNeighbor;
        } // end while
        return result;
    } // end getUnvisitedNeighbor

    @Override
    public void setPredecessor(VertexInterface<T> predecessor)
    {
        previousVertex = predecessor;
    }

    @Override
    public VertexInterface<T> getPredecessor()
    {
        return previousVertex;
    }

    @Override
    public boolean hasPredecessor()
    {
        return previousVertex != null;
    }

    @Override
    public void setCost(double newCost)
    {
        cost = newCost;
    }

    @Override
    public double getCost()
    {
        return cost;
    }

    public boolean equals(Object other)
    {
        boolean result;
        if ((other == null) || (getClass() != other.getClass()))
            result = false;
        else
        {
            Vertex<T> otherVertex = (Vertex<T>)other;
            result = label.equals(otherVertex.label);
        } // end if
        return result;
    } // end equals

    public String toString()
    {
        return label.toString();
    } // end toString

    protected class Edge
    {
        private VertexInterface<T> vertex; // end vertex
        private double weight;

        protected Edge(VertexInterface<T> endVertex, double edgeWeight)
        {
            vertex = endVertex;
            weight = edgeWeight;
        } // end constructor
        protected VertexInterface<T> getEndVertex()
        {
            return vertex;
        } // end getEndVertex
        protected double getWeight()
        {
            return weight;
        } // end getWeight
    }

    private class NeighborIterator implements Iterator<VertexInterface<T>>
    {
        private Iterator<Edge> edges;

        private NeighborIterator()
        {
            edges = edgeList.iterator();
        } // end default constructor

        public boolean hasNext()
        {
            return edges.hasNext();
        } // end hasNext

        public VertexInterface<T> next()
        {
            VertexInterface<T> nextNeighbor = null;
            if (edges.hasNext())
            {
                Edge edgeToNextNeighbor = edges.next();
                nextNeighbor = edgeToNextNeighbor.getEndVertex();
            }
            else
                throw new NoSuchElementException();
            return nextNeighbor;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    }

    private class WeightIterator implements Iterator<Double>
    {

        private Iterator<Edge> edges;

        private WeightIterator()
        {
            edges = edgeList.iterator();
        } // end default constructor

        public boolean hasNext()
        {
            return edges.hasNext();
        } // end hasNext

        public Double next()
        {
            Double edgeWeight = new Double(0);

            if (edges.hasNext())
            {
                Edge edgeToNextNeighbor = edges.next();
                edgeWeight = edgeToNextNeighbor.getWeight();
            }
            else
                throw new NoSuchElementException();
            return edgeWeight;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    }
}


