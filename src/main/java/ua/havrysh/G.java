package ua.havrysh;

import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class G {

    private final Set<Edge> edges;

    public G() {
        this.edges = Set.of();
    }

    public G(Set<Edge> edges) {
        this.edges = edges;
    }

    public G addEdge(int v1, int v2) {
        edges.add(new Edge(v1, v2));
        return this;
    }

    public Set<Integer> getVertices() {
        return edges.stream()
                .flatMap(e -> e.getVertices().stream())
                .collect(Collectors.toSet());
    }

    public int getDegree(int vertex) {
//        edges.stream()
//                .filter(e -> e.getVertices().size() > 1 && e.getVertices().contains(vertex))
//                .map(_e -> 1)
//                .mapToInt(Integer::intValue)
//                .sum();
        return edges.stream()
                .map(e -> e.getVertices().size() == 1
                        ? 0
                        : (e.getVertices().contains(vertex) ? 1 : 0))
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 0 - not eulerian (not connected or no of verticess with odd degree is gt 2);
    // 1 - has euler path(semi-eulerian) no of vertices with odd degree is 2
    // 2 - has euer C ciruit: no of vertices with odd degree is 0
    int getEulerianRate() {
        var connectedVertices = getConnectedVertices();
        if (getVertices().size() > connectedVertices.size()) return 0;
        var verticesCountWithOddDegree = getVerticesCountWithOddDegree();
        if (verticesCountWithOddDegree == 0) return 2;
        if (verticesCountWithOddDegree == 2) return 1;
        return 0;
    }

    int getVerticesCountWithOddDegree() {
        return getVertices().stream().filter(v -> getDegree(v)%2!=0).mapToInt(v -> 1).sum();
    }

    public Set<Integer> getConnectedVertices() {
        return edges.stream().reduce(
                Set.of(),
                (acc, e) -> {
                    if (acc.isEmpty()) return e.getVertices();
                    return acc.retainAll(e.getVertices())
                            ? merge(acc, e.getVertices())
                            : acc;
                },
                this::merge);
    }

    private <T> Tuple<Optional<T>, Set<T>> takeFirst(Set<T> elems, Predicate<T> p) {
        var found = elems.stream().filter(p::test).findFirst();
        var rest = found.isEmpty()
                ? elems
                : elems.stream().filter(e -> e.equals(found.get())).collect(Collectors.toSet());

        return new Tuple(found, rest);
    }

    private <T> Set<T> merge(Set<T> s1, Set<T> s2) {
        return Stream
                .concat(s1.stream(), s2.stream())
                .collect(Collectors.toSet());
    }

    record Tuple<K, V>(K k, V v) {}
}
