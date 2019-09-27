package ru.pelmegov.graph.graph;

import org.junit.jupiter.api.Test;
import ru.pelmegov.graph.GraphLibrary;
import ru.pelmegov.graph.config.Direction;
import ru.pelmegov.graph.config.GraphConfig;
import ru.pelmegov.graph.vertex.Vertex;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectedGraphTest {

    private Graph<String> graph = GraphLibrary.createGraph(
            GraphConfig.builder().direction(Direction.DIRECTED).build()
    );

    @Test
    void shouldAddNewVertexAndReturnIt() {
        Vertex<String> vertex = graph.addVertex(new Vertex<>("Moscow"));
        assertEquals("Moscow", vertex.getValue());
    }

}