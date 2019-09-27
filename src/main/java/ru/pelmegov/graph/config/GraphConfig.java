package ru.pelmegov.graph.config;

import lombok.Builder;
import lombok.Data;
import ru.pelmegov.graph.path.SearchStrategy;

@Builder
@Data
public final class GraphConfig {

    /**
     * You can choose graph direction, changing this config option
     */
    private Direction direction;

    /**
     * Use this flag for create thread safe graph
     */
    private boolean threadSafe;

    /**
     * Searching strategy
     * <p>
     * You can implement this interface for realize custom searching strategy
     * or choose one of default implementations
     */
    private SearchStrategy strategy;

}
