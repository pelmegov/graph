package ru.pelmegov.graph.edge;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.pelmegov.graph.vertex.Vertex;

@Data
@RequiredArgsConstructor
public class Edge<T> {

    private final Vertex<T> from;
    private final Vertex<T> to;

}
