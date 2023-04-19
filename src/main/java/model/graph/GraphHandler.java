package model.graph;

import model.graph.util.Graph;
import model.graph.util.GraphBuilder;
import model.graph.util.Node;
import model.util.exceptions.InvalidNode;

public class GraphHandler {

    private static GraphHandler INSTANCE;
    private final Graph graph;
    private final GraphBuilder builder;

    /**
     * Private constructor to control the amount of instances of this class
     */
    private GraphHandler() {
        this.builder = new GraphBuilder("Board");
        this.graph = builder.build();
    }

    /**
     * Method to realise a singleton
     * @return instance of GraphHandler
     */
    public static GraphHandler getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new GraphHandler();
        }

        return INSTANCE;
    }

    public Node findNode(int id) throws InvalidNode {
        return this.graph.findNode(id);
    }

}
