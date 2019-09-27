package ru.pelmegov.graph;

import org.junit.jupiter.api.Test;
import ru.pelmegov.graph.config.Direction;
import ru.pelmegov.graph.config.GraphConfig;
import ru.pelmegov.graph.edge.Edge;
import ru.pelmegov.graph.graph.Graph;
import ru.pelmegov.graph.path.DfsSearchStrategy;
import ru.pelmegov.graph.vertex.Vertex;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphLibraryTest {

    @Test
    void fullGraphTest() {
        Graph<Integer> graph = GraphLibrary.createGraph(
                GraphConfig.builder()
                        .threadSafe(true)
                        .direction(Direction.UNDIRECTED)
                        .strategy(new DfsSearchStrategy())
                        .build()
        );

        Vertex<Integer> one = new Vertex<>(1);
        Vertex<Integer> two = new Vertex<>(2);
        Vertex<Integer> three = new Vertex<>(3);
        Vertex<Integer> four = new Vertex<>(4);

        graph.addVertex(one);
        graph.addVertex(two);
        graph.addVertex(three);
        graph.addVertex(four);

        Edge<Integer> oneToTwo = new Edge<>(one, two);
        Edge<Integer> twoToThree = new Edge<>(two, three);
        Edge<Integer> threeToFour = new Edge<>(three, four);

        graph.addEdge(oneToTwo);
        graph.addEdge(twoToThree);
        graph.addEdge(threeToFour);

        List<Edge<Integer>> path = graph.getPath(one, four);

        assertEquals(oneToTwo, path.get(0));
        assertEquals(twoToThree, path.get(1));
        assertEquals(threeToFour, path.get(2));
    }
}