package ua.havrysh;

public class Graph {

    private final Node root;

    public Graph() {
        this.root = Node.of(0);
    }

    private Graph(Node root) {
        this.root = root;
    }

    Graph addEdge(int from, int to) {
        return new Graph(root.traverse(from, n -> n.to(to)));
    }
}
