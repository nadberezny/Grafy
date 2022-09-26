package com.company;
public class Main {

    public static void main(String args[])
    {
        // Let us create and test graphs shown in above figures
        Eulerian_circuit g1 = new Eulerian_circuit(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.test();

        Eulerian_circuit g2 = new Eulerian_circuit(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        g2.test();

        Eulerian_circuit g3 = new Eulerian_circuit(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        g3.test();

        // Let us create a graph with 3 vertices
        // connected in the form of cycle
        Eulerian_circuit g4 = new Eulerian_circuit(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        g4.test();

        // Let us create a graph with all vertices
        // with zero degree
        Eulerian_circuit g5 = new Eulerian_circuit(3);
        g5.test();





    }
}
