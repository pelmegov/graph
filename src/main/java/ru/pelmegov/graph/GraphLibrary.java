package ru.pelmegov.graph;

import lombok.NonNull;
import ru.pelmegov.graph.config.GraphConfig;
import ru.pelmegov.graph.graph.DirectedGraph;
import ru.pelmegov.graph.graph.Graph;
import ru.pelmegov.graph.graph.ThreadSafeGraph;
import ru.pelmegov.graph.graph.UndirectedGraph;
import ru.pelmegov.graph.path.BfsSearchStrategy;
import ru.pelmegov.graph.path.SearchStrategy;

/***
 *     $$$$$$\                                $$\
 *    $$  __$$\                               $$ |
 *    $$ /  \__| $$$$$$\   $$$$$$\   $$$$$$\  $$$$$$$\
 *    $$ |$$$$\ $$  __$$\  \____$$\ $$  __$$\ $$  __$$\
 *    $$ |\_$$ |$$ |  \__| $$$$$$$ |$$ /  $$ |$$ |  $$ |
 *    $$ |  $$ |$$ |      $$  __$$ |$$ |  $$ |$$ |  $$ |
 *    \$$$$$$  |$$ |      \$$$$$$$ |$$$$$$$  |$$ |  $$ |
 *     \______/ \__|       \_______|$$  ____/ \__|  \__|
 *                                  $$ |
 *                                  $$ |
 *                                  \__|
 *
 *                        $$\       $$\ $$\
 *                        $$ |      \__|$$ |
 *    Author:             $$ |      $$\ $$$$$$$\   $$$$$$\   $$$$$$\   $$$$$$\  $$\   $$\
 *    Pelmegov S.A.       $$ |      $$ |$$  __$$\ $$  __$$\  \____$$\ $$  __$$\ $$ |  $$ |
 *                        $$ |      $$ |$$ |  $$ |$$ |  \__| $$$$$$$ |$$ |  \__|$$ |  $$ |
 *                        $$ |      $$ |$$ |  $$ |$$ |      $$  __$$ |$$ |      $$ |  $$ |
 *                        $$$$$$$$\ $$ |$$$$$$$  |$$ |      \$$$$$$$ |$$ |      \$$$$$$$ |
 *                        \________|\__|\_______/ \__|       \_______|\__|       \____$$ |
 *                                                                              $$\   $$ |
 *                                                                              \$$$$$$  |
 *                                                                               \______/
 */
public final class GraphLibrary {

    /**
     * Method creates a new graph.
     * <p>
     * You can choose some options using GraphConfig object:
     * 1. Thread safe graph or not
     * 2. Graph directed or undirected
     * 3. Default path searching strategy (bfs or dfs) or your custom searching strategy
     *
     * @param config configuration object
     * @return a configured new graph
     */
    public static <T> Graph<T> createGraph(@NonNull GraphConfig config) {
        SearchStrategy<T> strategy = extractStrategy(config);
        Graph<T> graph = createGraph(config, strategy);
        if (config.isThreadSafe()) {
            graph = new ThreadSafeGraph<>(graph, strategy);
        }
        return graph;
    }


    private static <T> SearchStrategy<T> extractStrategy(@NonNull GraphConfig config) {
        if (config.getStrategy() == null) {
            return new BfsSearchStrategy<>();
        } else {
            return config.getStrategy();
        }
    }

    private static <T> Graph<T> createGraph(@NonNull GraphConfig config, @NonNull SearchStrategy<T> strategy) {
        switch (config.getDirection()) {
            case DIRECTED:
                return new DirectedGraph<>(strategy);
            case UNDIRECTED:
                return new UndirectedGraph<>(strategy);
            default:
                throw new IllegalArgumentException();
        }
    }

}
