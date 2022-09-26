package ua.havrysh;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public final class Node {

    private final int id;

    private final LinkedList<Node> outgoing;

    public static Node of(int id) {
        return new Node(id, new LinkedList<>());
    }

    public Node(int id, LinkedList<Node> outgoing) {
        this.id = id;
        this.outgoing = outgoing;
    }

    public Node find(int id) {
        if (this.id == id) return this;

        return outgoing.stream().map(o -> o.find(id)).findFirst().get();
    }

    public Node traverse(int id, Function<Node, Node> f) {
        if (this.id == id) return f.apply(this);

        var newOutgoing = outgoing.stream()
                .map(o -> o.traverse(id, f))
                .toList();
        return new Node(this.id, new LinkedList<>(newOutgoing));
    }

    public int id() {
        return id;
    }

    public List<Node> outgoing() {
        return outgoing;
    }

    public Node to(int id) {
        return to(Node.of(id));
    }

    public Node to(Node node) {
        outgoing.add(node);
        return this;
    }
}
