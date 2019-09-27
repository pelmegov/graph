package ru.pelmegov.graph.graph;

import lombok.NonNull;
import ru.pelmegov.graph.edge.Edge;
import ru.pelmegov.graph.exception.VertexNotFoundException;
import ru.pelmegov.graph.path.SearchStrategy;
import ru.pelmegov.graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Graph<T> {

    private final SearchStrategy<T> searchStrategy;

    protected final Map<Vertex<T>, List<Vertex<T>>> vertexes = new HashMap<>();
    protected final List<Edge<T>> edges = new ArrayList<>();

    protected Graph(SearchStrategy<T> searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public Vertex<T> addVertex(@NonNull Vertex<T> vertex) {
        vertexes.putIfAbsent(vertex, new ArrayList<>());
        return vertex;
    }

    public Edge<T> addEdge(@NonNull Edge<T> edge) {
        Vertex<T> from = edge.getFrom();
        Vertex<T> to = edge.getTo();
        if (!vertexes.containsKey(from)) {
            throw new VertexNotFoundException(from);
        }
        if (!vertexes.containsKey(to)) {
            throw new VertexNotFoundException(to);
        }
        vertexes.get(from).add(to);
        edges.add(edge);
        return edge;
    }

    public List<Edge<T>> getPath(@NonNull Vertex<T> from, @NonNull Vertex<T> to) {
        return searchStrategy.getPath(from, to, vertexes, edges);
    }

}
