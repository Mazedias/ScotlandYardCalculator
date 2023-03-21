package model.graph;

import model.graph.util.Graph;
import model.graph.util.GraphBuilder;

public class GraphHandler {

    private static GraphHandler INSTANCE;
    private final Graph graph;
    private final GraphBuilder builder;

    private GraphHandler() {
        this.builder = new GraphBuilder("Board");
        this.graph = builder.build();
    }

    public static GraphHandler getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new GraphHandler();
        }

        return INSTANCE;
    }

}
