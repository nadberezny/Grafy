package ua.havrysh;

import java.util.HashSet;
import java.util.Set;

public final class Edge {

    private final Set<Integer> vertices = new HashSet<>();

    public Edge(int v1, int v2) {
        this.vertices.add(v1);
        this.vertices.add(v2);
    }

    public boolean isIdentity() {
        return vertices.size() == 1;
    }

    public Set<Integer> getVertices() {
        return this.vertices;
    }
}
