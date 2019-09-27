package ru.pelmegov.graph.exception;

import ru.pelmegov.graph.vertex.Vertex;

public class VertexNotFoundException extends RuntimeException {

    public VertexNotFoundException(Vertex v) {
        super(String.format("Vertex %s not found", v));
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return new StackTraceElement[0];
    }
}
