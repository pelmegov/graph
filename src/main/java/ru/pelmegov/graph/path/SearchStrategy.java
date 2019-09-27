package ru.pelmegov.graph.path;

import ru.pelmegov.graph.edge.Edge;
import ru.pelmegov.graph.exception.EdgeNotFoundException;
import ru.pelmegov.graph.vertex.Vertex;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public interface SearchStrategy<T> {

    List<Edge<T>> getPath(Vertex<T> from, Vertex<T> to, Map<Vertex<T>, List<Vertex<T>>> vertexes, List<Edge<T>> edges);

    default void populatePath(List<Vertex<T>> foundPath, List<Edge<T>> edges, List<Edge<T>> path) {
        IntStream.range(0, foundPath.size())
                .takeWhile(i -> i + 1 != foundPath.size())
                .mapToObj(i -> {
                    Vertex<T> from = foundPath.get(i);
                    Vertex<T> to = foundPath.get(i + 1);
                    return extractEdge(edges, from, to);
                })
                .forEach(path::add);
    }

    default Edge<T> extractEdge(List<Edge<T>> edges, Vertex<T> from, Vertex<T> to) {
        return edges.stream()
                .filter(e -> e.getFrom().equals(from) && e.getTo().equals(to))
                .findFirst().orElseThrow(() -> new EdgeNotFoundException(from, to));
    }

}
