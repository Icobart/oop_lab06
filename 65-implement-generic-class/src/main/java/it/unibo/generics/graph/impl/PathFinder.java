package it.unibo.generics.graph.impl;

import java.util.LinkedList;
import java.util.List;

class PathFinder<N> {
    private final PathFinder<N> previous;
    private final N current;

    PathFinder(final N pos) {
        this(null, pos);
    }

    PathFinder(final PathFinder<N> previous, final N pos) {
        this.previous = previous;
        this.current = pos;
    }

    N getPosition() {
        return this.current;
    }

    public List<N> resultPath() {
        final List<N> pathList = new LinkedList<>();
        PathFinder<N> node = this;
        do {
            pathList.add(0, node.current);
            node = node.previous;
        } while(node != null);
        return pathList;
    }

    public String toString() {
        return "PathFinder [previous=" + previous + ", current=" + current + "]";
    }

}