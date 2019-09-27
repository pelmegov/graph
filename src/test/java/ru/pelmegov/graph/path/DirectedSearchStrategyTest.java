package ru.pelmegov.graph.path;

import org.junit.jupiter.api.Test;
import ru.pelmegov.graph.edge.Edge;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectedSearchStrategyTest extends DirectedGraphData {

    private SearchStrategy<String> dfsSearchStrategy = new DfsSearchStrategy<>();
    private SearchStrategy<String> bfsSearchStrategy = new BfsSearchStrategy<>();

    @Test
    void getPathBetweenBrusselsAndRomeUsingDfsStrategy() {
        // SEE PICTURE #2 - resources/directed_graph.png
        List<Edge<String>> dfsPath = dfsSearchStrategy.getPath(brussels, rome, adjacencyList, edgesBetweenCities);
        validatePath(dfsPath);
    }

    @Test
    void getPathBetweenBrusselsAndRomeUsingBfsStrategy() {
        // SEE PICTURE #2 - resources/directed_graph.png
        List<Edge<String>> bfsPath = bfsSearchStrategy.getPath(brussels, rome, adjacencyList, edgesBetweenCities);
        validatePath(bfsPath);
    }

    private void validatePath(List<Edge<String>> path) {
        assertEquals(brusselsToFrankfurt, path.get(0));
        assertEquals(frankfurtToAmsterdam, path.get(1));
        assertEquals(amsterdamToCologne, path.get(2));
        assertEquals(cologneToRome, path.get(3));
    }

}