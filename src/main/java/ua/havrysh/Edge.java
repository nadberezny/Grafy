package ua.havrysh;

import java.util.Set;

public final class Edge {

    private final Set<Integer> vertices = Set.of();

    private boolean visited = false;

    public Edge(int v1, int v2) {
        this.vertices.add(v1);
        this.vertices.add(v2);
    }

    public void visit() {
        this.visited = true;
    }

    public Set<Integer> getVertices() {
        return this.vertices;
    }


}
