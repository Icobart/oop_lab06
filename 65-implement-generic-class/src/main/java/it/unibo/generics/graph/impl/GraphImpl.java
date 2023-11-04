package it.unibo.generics.graph.impl;

import java.util.Collections;
import java.util.Deque;
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

    public GraphImpl() {

    }

    public void addNode(final N node) {
        if(!this.nodes.containsKey(node) && node != null) {
            this.nodes.put(node, new HashSet<>());
        }
    }

    public void addEdge(final N source, final N target) {
        if(source != null && target != null && this.nodes.containsKey(source)
             && this.nodes.containsKey(target)) {
            this.nodes.get(source).add(target);
        }    
    }

    public Set<N> nodeSet() {
        return new HashSet<>(this.nodes.keySet());
    }

    public Set<N> linkedNodes(final N node) {
        return this.nodes.get(node);
    }

    public List<N> getPath(final N source, final N target) {
        if(source != null && target != null && this.nodes.containsKey(source)
             && this.nodes.containsKey(target)) {
            return graphVisit(source, target);
        } else {
            return Collections.emptyList();
        }
    }

    private List<N> graphVisit (final N source, final N target) {
        final Deque<PathFinder<N>> savedNode = new LinkedList<>();
        savedNode.add(new PathFinder<>(source));
        final Set<N> visited = new HashSet<>();
        while(!savedNode.isEmpty() && visited.size() < nodeSet().size()) {
            final PathFinder<N> last = savedNode.removeFirst();
            final N nodeVisit = last.getPosition();
            if(nodeVisit.equals(target)) {
                return last.resultPath();
            } else if(!visited.contains(nodeVisit)){
                visited.add(nodeVisit);
                updateDeque(savedNode, last);
            }
        }
        return Collections.emptyList();
    }

    private void updateDeque(final Deque<PathFinder<N>> savedNode, final PathFinder<N> last) {
        final N currentPos = last.getPosition();
        for (final N nextNode : linkedNodes(currentPos)) {
            savedNode.addFirst(new PathFinder<>(last, nextNode));
        }
    }
    
}