package ru.pelmegov.graph.graph;

import lombok.NonNull;
import ru.pelmegov.graph.edge.Edge;
import ru.pelmegov.graph.path.SearchStrategy;

public class UndirectedGraph<T> extends Graph<T> {

    public UndirectedGraph(SearchStrategy<T> searchStrategy) {
        super(searchStrategy);
    }

    @Override
    public Edge<T> addEdge(@NonNull Edge<T> edge) {
        Edge<T> addedEdge = super.addEdge(edge);
        vertexes.get(edge.getTo()).add(edge.getFrom());
        return addedEdge;
    }

}
