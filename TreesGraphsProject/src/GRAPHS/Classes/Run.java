package GRAPHS.Classes;

import GRAPHS.ADT_Package.LinkedStack;
import GRAPHS.ADT_Package.StackInterface;
import GRAPHS.Interfaces.VertexInterface;

/**
 * Created by christianhasselstrom on 01/05/2016.
 */
public class Run
{
    public static void main(String[] args)
    {
        UndirectedGraph<String> letterGraph = new UndirectedGraph<>();

        letterGraph.addVertex("A");
        letterGraph.addVertex("B");
        letterGraph.addVertex("C");
        letterGraph.addVertex("D");

        letterGraph.addEdge("A", "B", 2);
        letterGraph.addEdge("B", "D", 4);
        letterGraph.addEdge("D", "C", 1);
        letterGraph.addEdge("C", "A", 5);

        StackInterface<String> path = new LinkedStack<>();
        double num = letterGraph.getCheapestPath("D", "A", path);
        System.out.println(num);


    }
}
