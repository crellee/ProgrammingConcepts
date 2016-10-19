package GRAPHS.Classes;

import GRAPHS.ADT_Package.LinkedQueue;
import GRAPHS.ADT_Package.LinkedStack;
import GRAPHS.ADT_Package.QueueInterface;
import GRAPHS.ADT_Package.StackInterface;
import GRAPHS.Interfaces.GraphInterface;
import GRAPHS.Interfaces.VertexInterface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by christianhasselstrom on 01/05/2016.
 */
public class DirectedGraph<T> implements GraphInterface<T>
{
    protected Map<T, VertexInterface<T>> vertices;
    protected int edgeCount;

    public DirectedGraph()
    {
        vertices = new HashMap<>();
        edgeCount = 0;
    } // end default constructor

    @Override
    public boolean addVertex(T vertexLabel)
    {
        VertexInterface<T> isDuplicate = vertices.put(vertexLabel, new Vertex(vertexLabel));
        return isDuplicate == null; // was add to dictionary successful?
    }

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight)
    {
        boolean result = false;

        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ( (beginVertex != null) && (endVertex != null) )
            result = beginVertex.connect(endVertex, edgeWeight);
        if (result)
            edgeCount++;

        return result;
    }

    @Override
    public boolean addEdge(T begin, T end)
    {
        return addEdge(begin, end, 0);
    } // end addEdge

    @Override
    public boolean hasEdge(T begin, T end)
    {
        boolean found = false;

        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ( (beginVertex != null) && (endVertex != null) )
        {
            Iterator<VertexInterface<T>> neighbors =
                    beginVertex.getNeighborIterator();
            while (!found && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                    found = true;
            } // end while
        } // end if
        return found;
    } // end hasEdge

    @Override
    public boolean isEmpty()
    {
        return vertices.isEmpty();
    }

    @Override
    public int getNumberOfVertices()
    {
        return vertices.size();
    }

    @Override
    public int getNumberOfEdges()
    {
        return edgeCount;
    }

    @Override
    public void clear()
    {
        vertices.clear();
        edgeCount = 0;
    }

    protected void resetVertices()
    {
        Iterator<Map.Entry<T, VertexInterface<T>>> entries = vertices.entrySet().iterator();
        while (entries.hasNext())
        {
            VertexInterface<T> nextVertex = entries.next().getValue();
            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        }
    } // end resetVertices

    //Returns map of vertices.
    //Using it to print vertices when testing in run class
    public Map<T, VertexInterface<T>> getVertices()
    {
        return vertices;
    }

    @Override
    public QueueInterface<T> getBreadthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();

        VertexInterface<T> originVertex = vertices.get(origin);
        originVertex.visit();

        traversalOrder.enqueue(origin); // enqueue vertex label
        vertexQueue.enqueue(originVertex); // enqueue vertex

        while (!vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors =
                    frontVertex.getNeighborIterator();
            while (neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();

                if (!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                }
            }
        }
        return traversalOrder;
    } // end getBreadthFirstTraversal

    @Override
    public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<VertexInterface<T>> traversalOrder = new LinkedQueue<>();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();

        VertexInterface<T> originVertex = vertices.get(origin);
        originVertex.visit();
        traversalOrder.enqueue(originVertex);
        vertexStack.push(originVertex);

        while (!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex = vertexStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();

            if (nextNeighbor != null)
            {
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor);
                vertexStack.push(nextNeighbor);
            }
            else
            {   // all neighbors are visited
                vertexStack.pop();
            }
        }
        return (QueueInterface<T>) traversalOrder;
    }

    @Override
    public StackInterface<T> getTopologicalOrder()
    {
        resetVertices();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();

        Iterator<Map.Entry<T, VertexInterface<T>>> iterator = vertices.entrySet().iterator();
        while (iterator.hasNext())
        {
            VertexInterface<T> nextVertex = iterator.next().getValue();
            if (!nextVertex.isVisited())
            {
                if(nextVertex.getUnvisitedNeighbor() != null)
                {
                    nextVertex.visit();
                    System.out.println(nextVertex.toString());
                    vertexStack.push(nextVertex);
                }
            }
        }
        return (StackInterface<T>) vertexStack;
    }

    @Override
    public int getShortestPath(T begin, T end, StackInterface<T> path)
    {
        resetVertices();

        boolean done = false;
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();

        VertexInterface<T> originVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        originVertex.visit();
        vertexQueue.enqueue(originVertex);

        while (!done && !vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
            while (!done && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    nextNeighbor.setCost(1 + frontVertex.getCost());
                    nextNeighbor.setPredecessor(frontVertex);
                    vertexQueue.enqueue(nextNeighbor);
                }
                if (nextNeighbor.equals(endVertex))
                    done = true;
            }
        }

        // traversal ends; construct shortest path
        int pathLength = (int) endVertex.getCost();
        path.push(endVertex.getLabel());
        VertexInterface<T> vertex = endVertex;
        System.out.println(endVertex.toString());
        while (vertex.hasPredecessor())
        {
            vertex = vertex.getPredecessor();
            path.push(vertex.getLabel());
            System.out.println(vertex.toString());
        } // end while
        return pathLength;
    } // end getShortestPath

    @Override
    public double getCheapestPath(T begin, T end, StackInterface<T> path)
    {
        resetVertices();

        boolean done = false;
        PriorityQueue<EntryPQ> prQueue = new PriorityQueue<>();

        VertexInterface<T> originVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        prQueue.add(new EntryPQ(originVertex,0,null));

        while (!done && !prQueue.isEmpty())
        {
            EntryPQ frontEntry = prQueue.poll();
            VertexInterface<T> frontVertex = frontEntry.getVertex();

            if (!frontVertex.isVisited())
            {
                frontVertex.visit();
                frontVertex.setCost(frontEntry.getCost());
                frontVertex.setPredecessor(frontEntry.getPredecessor());

                if(frontVertex.equals(endVertex))
                {
                    done  = true;
                }
                else
                {
                    Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
                    Iterator<Double> edgeWeights = frontVertex.getWeightIterator();

                    while (neighbors.hasNext())
                    {
                        VertexInterface<T> nextNeighbor = neighbors.next();
                        Double weightOfEdgeToNeighbor = edgeWeights.next();

                        if (!nextNeighbor.isVisited())
                        {
                            double nextCost = weightOfEdgeToNeighbor + frontVertex.getCost();
                            prQueue.add(new EntryPQ(nextNeighbor, nextCost, frontVertex));
                        } // end if
                    }
                }
            }
        }
        // traversal ends; construct cheapest path

        double pathCost = endVertex.getCost();
        path.push(endVertex.getLabel());

        VertexInterface<T> vertex = endVertex;
        while (vertex.hasPredecessor())
        {
            vertex = vertex.getPredecessor();
            System.out.println(vertex.toString());
            path.push(vertex.getLabel());
        }
        return pathCost;
    }

    private class EntryPQ implements Comparable<EntryPQ>, java.io.Serializable
    {
        private VertexInterface<T> vertex;
        private VertexInterface<T> previousVertex;
        private double cost; // cost to nextVertex

        private EntryPQ(VertexInterface<T> vertex, double cost, VertexInterface<T> previousVertex)
        {
            this.vertex = vertex;
            this.previousVertex = previousVertex;
            this.cost = cost;
        } // end constructor

        public VertexInterface<T> getVertex()
        {
            return vertex;
        } // end getVertex

        public VertexInterface<T> getPredecessor()
        {
            return previousVertex;
        } // end getPredecessor

        public double getCost()
        {
            return cost;
        } // end getCost

        public int compareTo(EntryPQ otherEntry)
        {
            // using opposite of reality since our priority queue uses a maxHeap;
            // could revise using a minheap
            return (int)Math.signum(cost - otherEntry.cost );
        } // end compareTo

        public String toString()
        {
            return vertex.toString() + " " + cost;
        } // end toString
    } // end EntryPQ
}