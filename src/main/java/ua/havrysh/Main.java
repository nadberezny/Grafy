package ua.havrysh;

import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Font;
import guru.nidi.graphviz.attribute.Rank;
import guru.nidi.graphviz.attribute.Style;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

import static guru.nidi.graphviz.attribute.Attributes.attr;
import static guru.nidi.graphviz.attribute.Rank.RankDir.LEFT_TO_RIGHT;
import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;
import static guru.nidi.graphviz.model.Link.to;

public class Main {

    private static final Logger logger = LogManager.getLogger("HelloWorld");

    public static void main(String args[]) throws IOException {
        logger.info("AAAAAAAAAAAAAAAAAAAAAAAA");
//        Eulerian_circuit g1 = new Eulerian_circuit(5);
//        g1.addEdge(1, 0);
//        g1.addEdge(0, 2);
//        g1.addEdge(2, 1);
//        g1.addEdge(0, 3);
//        g1.addEdge(3, 4);
//        g1.test();
//
//        Eulerian_circuit g2 = new Eulerian_circuit(5);
//        g2.addEdge(1, 0);
//        g2.addEdge(0, 2);
//        g2.addEdge(2, 1);
//        g2.addEdge(0, 3);
//        g2.addEdge(3, 4);
//        g2.addEdge(4, 0);
//        g2.test();
//
//        Eulerian_circuit g3 = new Eulerian_circuit(5);
//        g3.addEdge(1, 0);
//        g3.addEdge(0, 2);
//        g3.addEdge(2, 1);
//        g3.addEdge(0, 3);
//        g3.addEdge(3, 4);
//        g3.addEdge(1, 3);
//        g3.test();
//
//        // 3 vertices connected in the form of cycle
//        Eulerian_circuit g4 = new Eulerian_circuit(3);
//        g4.addEdge(0, 1);
//        g4.addEdge(1, 2);
//        g4.addEdge(2, 0);
//        g4.test();
//
//        // vertices with zero degree
//        Eulerian_circuit g5 = new Eulerian_circuit(3);
//        g5.test();

        var g = graph("example1").directed()
                .graphAttr().with(Rank.dir(LEFT_TO_RIGHT))
                .nodeAttr().with(Font.name("arial"))
                .linkAttr().with("class", "link-class")
                .with(
                        node("a").with(Color.RED).link(node("b")),
                        node("b").link(
                                to(node("c")).with(attr("weight", 5), Style.DASHED)
                        )
                );


//        Graphviz.fromGraph(g).height(100).render(Format.PNG).toFile(new File("example/ex1.png"));
//        var rendered = Graphviz.fromGraph(g).height(100).render(Format.JSON);
//        rendered.toString();
//        rendered.toFile(new File("example/ex1.png"));
        var x = Node.of(0).to(Node.of(1).to(Node.of(2).to(Node.of(0))));
        var gg = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0);
        var y = x;
//        System.out.println(y);
    }
}
