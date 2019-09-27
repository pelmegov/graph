package ru.pelmegov.graph.exception;

import ru.pelmegov.graph.vertex.Vertex;

public class EdgeNotFoundException extends RuntimeException {

    public EdgeNotFoundException(Vertex v1, Vertex v2) {
        super(String.format("Edge between vertexes %s and %s not found", v1, v2));
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return new StackTraceElement[0];
    }
}
