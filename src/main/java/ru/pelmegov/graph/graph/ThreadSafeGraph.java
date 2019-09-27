package ru.pelmegov.graph.graph;

import lombok.NonNull;
import ru.pelmegov.graph.edge.Edge;
import ru.pelmegov.graph.path.SearchStrategy;
import ru.pelmegov.graph.vertex.Vertex;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeGraph<T> extends Graph<T> {

    private final Graph<T> wrapped;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public ThreadSafeGraph(@NonNull Graph<T> graph, @NonNull SearchStrategy<T> searchStrategy) {
        super(searchStrategy);
        this.wrapped = graph;
    }

    @Override
    public Vertex<T> addVertex(@NonNull Vertex<T> vertex) {
        Vertex<T> result;

        Lock writeLock = this.lock.writeLock();
        writeLock.lock();
        try {
            result = wrapped.addVertex(vertex);
        } finally {
            writeLock.unlock();
        }
        return result;
    }

    @Override
    public Edge<T> addEdge(@NonNull Edge<T> edge) {
        Edge<T> result;

        Lock writeLock = this.lock.writeLock();
        writeLock.lock();
        try {
            result = wrapped.addEdge(edge);
        } finally {
            writeLock.unlock();
        }
        return result;
    }

    @Override
    public List<Edge<T>> getPath(@NonNull Vertex<T> from, @NonNull Vertex<T> to) {
        List<Edge<T>> result;

        Lock readLock = this.lock.readLock();
        readLock.lock();
        try {
            result = wrapped.getPath(from, to);
        } finally {
            readLock.unlock();
        }
        return result;
    }
}
