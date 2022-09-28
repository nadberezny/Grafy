package ua.havrysh;


import static guru.nidi.graphviz.model.Factory.mutGraph;
import static guru.nidi.graphviz.model.Factory.mutNode;

public class GraphVizTranslator {

    public static guru.nidi.graphviz.model.Graph translate(Graph g) {
        var vizGraph = mutGraph("example1");
        g.getEdges().forEach(e -> {
            var vertices = e.getVertices().toArray();
            if (e.isIdentity()) {
                vizGraph.add(mutNode(vertices[0].toString()));
            } else {
                vizGraph.add(
                        mutNode(vertices[0].toString())
                                .addLink(mutNode(vertices[1].toString()))
                        );
            }
        });
        return vizGraph.toImmutable();
    }
}
