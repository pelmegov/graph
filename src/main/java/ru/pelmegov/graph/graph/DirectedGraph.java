package ru.pelmegov.graph.graph;

import ru.pelmegov.graph.path.SearchStrategy;

public class DirectedGraph<T> extends Graph<T> {

    public DirectedGraph(SearchStrategy<T> searchStrategy) {
        super(searchStrategy);
    }

}
