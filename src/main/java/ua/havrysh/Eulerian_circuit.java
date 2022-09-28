package ua.havrysh;

import java.util.concurrent.atomic.AtomicInteger;

public class Eulerian_circuit {

    Node DFS(Node node) {
        return node.traverse(Node::visit);
    }

    boolean isConnected(Node root) {
        var firstNonZeroDegree = root.findFirst(node -> !node.isZeroDegree());

        if (firstNonZeroDegree.isEmpty()) return true;

        var visited = DFS(firstNonZeroDegree.get());
        var existsNonVisited = visited.findFirst(n -> !n.isZeroDegree() && !n.isVisited());

        return existsNonVisited.isEmpty();
    }

    /* The function returns one of the following values
       0 --> If graph is not Eulerian
       1 --> If graph has an Euler path (Semi-Eulerian)
       2 --> If graph has an Euler C ircuit (Eulerian)  */
    int isEulerian(Node node) {
        if (!isConnected(node)) return 0;

        // Count vertices with odd degree
        var odd = new AtomicInteger();
        node.forEach(n -> {
            if (n.degree()%2!=0) {
                odd.incrementAndGet();
            }
        });

        if (odd.get() > 2) return 0;

        // If odd count is 2, then semi-eulerian.
        // If odd count is 0, then eulerian
        return (odd.get() == 2) ? 1 : 2;
    }


    void test(Node node)
    {
        int res = isEulerian(node);
        if (res == 0)
            System.out.println("graph is not Eulerian");
        else if (res == 1)
            System.out.println("graph has an Euler path");
        else
            System.out.println("graph has an Euler cycle");
    }
    }
