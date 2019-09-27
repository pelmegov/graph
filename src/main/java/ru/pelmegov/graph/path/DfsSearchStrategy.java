package ru.pelmegov.graph.path;

import ru.pelmegov.graph.edge.Edge;
import ru.pelmegov.graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DfsSearchStrategy<T> implements SearchStrategy<T> {

    @Override
    public List<Edge<T>> getPath(Vertex<T> from, Vertex<T> to, Map<Vertex<T>, List<Vertex<T>>> vertexes, List<Edge<T>> edges) {
        if (to.equals(from)) {
            return List.of();
        }
        return traverseDfs(from, to, new ArrayList<>(List.of(from)), vertexes, edges, new ArrayList<>());
    }

    private List<Edge<T>> traverseDfs(Vertex<T> from,
                                      Vertex<T> to,
                                      List<Vertex<T>> localPath,
                                      Map<Vertex<T>, List<Vertex<T>>> vertexes,
                                      List<Edge<T>> edges,
                                      List<Edge<T>> path) {
        if (from.equals(to)) {
            populatePath(localPath, edges, path);
            return path;
        }
        vertexes.get(from).stream()
                .filter(vertex -> !localPath.contains(vertex))
                .forEach(vertex -> {
                    localPath.add(vertex);
                    traverseDfs(vertex, to, localPath, vertexes, edges, path);
                    localPath.remove(vertex);
                });
        return Collections.unmodifiableList(path);
    }

}
