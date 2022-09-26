package com.company;


import java.util.*;
import java.util.LinkedList;
public class Graph {
    protected int V;
    protected LinkedList<Integer>[] adj;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v, int w)
    {
        adj[v].add(w);// Add w to v's list.
        adj[w].add(v); //The graph is undirected
    }
}
