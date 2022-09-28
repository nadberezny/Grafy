package ua.havrysh;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {

    private final Set<Edge> edges;

    public Graph() {
        this.edges = new HashSet<>();
    }

    public Graph addEdge(int v1, int v2) {
        edges.add(new Edge(v1, v2));
        return this;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Set<Integer> getVertices() {
        return edges.stream()
                .flatMap(e -> e.getVertices().stream())
                .collect(Collectors.toSet());
    }

    public int getDegree(int vertex) {
        return edges.stream()
                .filter(e -> e.getVertices().size() > 1 && e.getVertices().contains(vertex))
                .map(_e -> 1)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 0 - not eulerian (not connected or no of verticess with odd degree is gt 2);
    // 1 - has euler path(semi-eulerian) no of vertices with odd degree is 2
    // 2 - has euer C ciruit: no of vertices with odd degree is 0
    public int getEulerianRate() {
        var connectedVertices = getConnectedVertices();
        if (getVertices().size() > connectedVertices.size()) return 0;
        var verticesCountWithOddDegree = getVerticesCountWithOddDegree();
        if (verticesCountWithOddDegree == 0) return 2;
        if (verticesCountWithOddDegree == 2) return 1;
        return 0;
    }

    public int getVerticesCountWithOddDegree() {
        return getVertices().stream().filter(v -> getDegree(v)%2!=0).mapToInt(v -> 1).sum();
    }

    public Set<Integer> getConnectedVertices() {
        return edges.stream().reduce(
                Set.of(),
                (acc, e) -> {
                    if (e.isIdentity()) return acc;
                    if (acc.isEmpty()) return e.getVertices();
                    var accCopy = new HashSet<>();
                    accCopy.addAll(acc);
                    return accCopy.retainAll(e.getVertices())
                            ? SetUtil.merge(acc, e.getVertices())
                            : acc;
                },
                SetUtil::merge);
    }
}
