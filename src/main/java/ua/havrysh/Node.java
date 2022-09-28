package ua.havrysh;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Node {

    private final int id;

    private LinkedList<Node> outgoing;

    private boolean isVisited = false;

    public static Node of(int id) {
        return new Node(id, new LinkedList<>());
    }

    public Node(int id, LinkedList<Node> outgoing) {
        this.id = id;
        this.outgoing = outgoing;
    }

    public Optional<Node> findFirst(Predicate<Node> p) {
        if (p.test(this)) return Optional.of(this);

        return outgoing.stream().filter(n -> p.test(n)).findFirst();
    }

    public Node find(int id) {
        if (this.id == id) return this;

        return outgoing.stream().map(o -> o.find(id)).findFirst().get();
    }

    public void forEach(Consumer<Node> nodeConsumer) {
        nodeConsumer.accept(this);
        this.outgoing.forEach(n -> n.forEach(nodeConsumer));
    }

    public Node traverse(Function<Node, Node> f) {
        var traversed = f.apply(this);

        var newOutgoing = f
                .apply(this)
                .outgoing
                .stream()
                .map(o -> o.traverse(f))
                .toList();
        traversed.setOutgoing(newOutgoing);
        return traversed;
    }

    public Node applyFor(int id, Function<Node, Node> f) {
        if (this.id == id) return f.apply(this);

        var newOutgoing = outgoing.stream()
                .map(o -> o.applyFor(id, f))
                .toList();
        return new Node(this.id, new LinkedList<>(newOutgoing));
    }

//    public <T> T aggregate(T aggregator, Function<Node>) {
//
//        return null;
//    }

    public int degree() {
        var deg = new AtomicInteger(0);
        forEach(n -> {
            n.outgoing.forEach(nn -> {
                if (nn.id() == this.id) {
                    deg.incrementAndGet();
                }
            });
        });
        return deg.get();
    }

    public boolean isZeroDegree() {
        return degree() == 0;
    }

    public int id() {
        return id;
    }

    public List<Node> outgoing() {
        return outgoing;
    }

    void setOutgoing(List<Node> o) {
        this.outgoing = new LinkedList<>(o);
    }

    public boolean isVisited() {
        return isVisited;
    }

    public Node visit() {
        isVisited = true;
        return this;
    }

    public Node to(int id) {
        return to(Node.of(id));
    }

    public Node to(Node node) {
        outgoing.add(node);
        return this;
    }
}
