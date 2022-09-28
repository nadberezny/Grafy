package ua.havrysh;

public class Graph {

    private final Node root;

    public Graph() {
        this.root = Node.of(0);
    }

    private Graph(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Graph addEdge(int from, int to) {
        return new Graph(root.applyFor(from, n -> n.to(to)));
    }
}
