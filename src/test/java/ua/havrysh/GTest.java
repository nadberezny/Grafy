package ua.havrysh;


import org.junit.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GTest {

    @Test
    public void testGetDegree() {
        var g0 = new Graph();
        g0.addEdge(0, 0);
        assertEquals(0, g0.getDegree(0));

        var g1 = new Graph();
        g1.addEdge(0, 1);
        assertEquals(1, g1.getDegree(0));
        assertEquals(1, g1.getDegree(1));

        var g3 = new Graph();
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        assertEquals(1, g3.getDegree(0));
        assertEquals(2, g3.getDegree(1));
        assertEquals(1, g3.getDegree(2));
    }

    @Test
    public void testGetConnectedVertices() {
        var g0 = new Graph();
        g0.addEdge(0, 1);
        g0.addEdge(1, 2);
        assertEquals(Set.of(0, 1, 2), g0.getConnectedVertices());

        var g1 = new Graph();
        g1.addEdge(0, 0);
        g1.addEdge(1, 2);
        assertEquals(Set.of(1, 2), g1.getConnectedVertices());
    }

    @Test
    public void testGetVerticesCountWithOddDegree() {
        var g0 = new Graph();
        g0.addEdge(0, 1);
        g0.addEdge(1, 2);
        assertEquals(2, g0.getVerticesCountWithOddDegree());
    }

    @Test
    public void testGetEulerianRate() {
        // not eulerian
        var g0 = new Graph();
        g0.addEdge(0, 0);
        assertEquals(0, g0.getEulerianRate());

        // euler path
        var g1 = new Graph();
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        assertEquals(1, g1.getEulerianRate());

        // euler cycle
        var g2 = new Graph();
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 0);
        assertEquals(2, g2.getEulerianRate());
    }

    @Test
    public void testGraphViz() throws IOException {
        var g0 = new Graph();
        g0.addEdge(0, 1);
        g0.addEdge(1, 2);
        g0.addEdge(2, 0);

        var visual = GraphVizTranslator.translate(g0);
//        Graphviz.fromGraph(visual).height(100).render(Format.PNG).toFile(new File("example/ex1.png"));
    }
}
