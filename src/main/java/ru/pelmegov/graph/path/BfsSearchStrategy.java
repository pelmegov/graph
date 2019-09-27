package ru.pelmegov.graph.path;

import ru.pelmegov.graph.edge.Edge;
import ru.pelmegov.graph.vertex.Vertex;

import java.util.*;

public class BfsSearchStrategy<T> implements SearchStrategy<T> {

    @Override
    public List<Edge<T>> getPath(Vertex<T> from, Vertex<T> to, Map<Vertex<T>, List<Vertex<T>>> vertexes, List<Edge<T>> edges) {
        if (to.equals(from)) {
            return List.of();
        }

        return traverseBfs(from, to, vertexes, edges);
    }

    private List<Edge<T>> traverseBfs(Vertex<T> from, Vertex<T> to, Map<Vertex<T>, List<Vertex<T>>> vertexes, List<Edge<T>> edges) {
        List<Edge<T>> result = new ArrayList<>();
        List<Vertex<T>> singlePath = new LinkedList<>();
        Queue<List<Vertex<T>>> pathsQueue = new LinkedList<>();
        singlePath.add(from);
        pathsQueue.add(singlePath);

        while (!pathsQueue.isEmpty()) {
            List<Vertex<T>> iterPath = pathsQueue.poll();
            if (iterPath.get(iterPath.size() - 1).equals(to)) {
                populatePath(iterPath, edges, result);
                return result;
            }
            vertexes.get(iterPath.get(iterPath.size() - 1)).stream()
                    .filter(currVertex -> !isVisited(iterPath, currVertex))
                    .forEach(currVertex -> {
                        var inner = new LinkedList<>(iterPath);
                        inner.add(currVertex);
                        pathsQueue.add(inner);
                    });
        }
        return Collections.unmodifiableList(result);
    }

    private boolean isVisited(List<Vertex<T>> iterPath, Vertex<T> currVertex) {
        return iterPath.stream()
                .anyMatch(fromPath -> fromPath.equals(currVertex));
    }

}
