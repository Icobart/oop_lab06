package it.unibo.generics.graph.impl;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> nodes = new LinkedHashMap<>();
    //private List<N> path = new LinkedList<>();

    public void addNode(N node) {
        if(nodes.get(node) == null && node != null) {
            nodes.put(node, new HashSet<>());
        }
    }

    public void addEdge(N source, N target) {
        if(source != null && target != null) {
            nodes.get(source).add(target);
        }    
    }

    public Set<N> nodeSet() {
        return new HashSet<>(nodes.keySet());
        //return nodes.keySet();
    }

    public Set<N> linkedNodes(N node) {
        return nodes.get(node);
    }

    public List<N> getPath(N source, N target) {
        List<N> path = new LinkedList<>();
        
        
        return path;
    }
    
}