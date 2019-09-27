package ru.pelmegov.graph.path;

import org.junit.jupiter.api.Test;
import ru.pelmegov.graph.edge.Edge;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UndirectedSearchStrategyTest extends UndirectedGraphData {

    private SearchStrategy<String> dfsSearchStrategy = new DfsSearchStrategy<>();
    private SearchStrategy<String> bfsSearchStrategy = new BfsSearchStrategy<>();

    @Test
    void getPathBetweenBrusselsAndRomeUsingDfsStrategy() {
        // SEE PICTURE #1 - resources/undirected_graph.png
        List<Edge<String>> dfsPath = dfsSearchStrategy.getPath(brussels, rome, adjacencyList, edgesBetweenCities);
        validatePath(dfsPath);
    }

    @Test
    void getPathBetweenBrusselsAndRomeUsingBfsStrategy() {
        // SEE PICTURE #1 - resources/undirected_graph.png
        List<Edge<String>> bfsPath = bfsSearchStrategy.getPath(brussels, rome, adjacencyList, edgesBetweenCities);
        validatePath(bfsPath);
    }

    private void validatePath(List<Edge<String>> path) {
        assertEquals(brusselsToAmsterdam, path.get(0));
        assertEquals(amsterdamToCologne, path.get(1));
        assertEquals(cologneToVienna, path.get(2));
        assertEquals(viennaToRome, path.get(3));
    }

}