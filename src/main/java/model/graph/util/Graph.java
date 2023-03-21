package model.graph.util;

import model.game.transportation.TransportationType;
import model.util.exceptions.InvalidNode;
import view.InputOutputHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private final HashMap<Node, List<Edge>> adjacencyList;
    private final String name;

    public Graph(String name) {
        this.name = name;
        this.adjacencyList = new HashMap<>();
    }

    /**
     * Adds a node to the graph
     * @param node Node ID
     */
    public void addNode(Node node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Removes a vertex from the graph
     * @param node Node ID
     */
    public void removeNode(Node node) throws InvalidNode {
        if (!(this.adjacencyList.containsKey(node))) {
            throw new InvalidNode("this graph does not contain the node " + node.toString());
        }

        this.adjacencyList.get(node).forEach(this::removeEdge);
        this.adjacencyList.remove(node);
    }

    /**
     * Adds an edge between two nodes
     * @param firstNode First node
     * @param secondNode Second node
     * @param vehicleType Type of vehicle
     * @throws InvalidNode Is thrown by an invalid node
     */
    public void addEdge(Node firstNode, Node secondNode, TransportationType vehicleType) throws InvalidNode {
        if (!(adjacencyList.containsKey(firstNode) && adjacencyList.containsKey(secondNode))) {
            throw new InvalidNode("a node is not in the graph");
        }

        Edge edge = new Edge(firstNode, secondNode, vehicleType);

        if (this.adjacencyList.get(firstNode).contains(edge) || this.adjacencyList.get(secondNode).contains(edge)) {
            InputOutputHandler.printDebugMessage("this edge already exists. Nodes: "
                    + firstNode.toString() + ";" + secondNode.toString());
            return;
        }

        adjacencyList.get(firstNode).add(edge);
        adjacencyList.get(secondNode).add(edge);
    }

    /**
     * Removes an edge between two nodes
     * @param firstNode First node
     * @param secondNode Second vertex
     * @param vehicleType Type of vehicle
     * @throws InvalidNode Is thrown by an invalid node
     */
    public void removeEdge(Node firstNode, Node secondNode, TransportationType vehicleType) throws InvalidNode {
        if (!(adjacencyList.containsKey(firstNode) && adjacencyList.containsKey(secondNode))) {
            throw new InvalidNode("a vertex is not in the graph");
        }

        if (adjacencyList.get(firstNode).isEmpty() || adjacencyList.get(secondNode).isEmpty()) {
            throw new InvalidNode("invalid vertex entry");
        }

        Edge edge = new Edge(firstNode, secondNode, vehicleType);

        // Remove the edge from both nodes in the adjList
        this.adjacencyList.get(firstNode).forEach(e -> {
            if (e.equals(edge)) this.adjacencyList.get(firstNode).remove(e);
        });
        this.adjacencyList.get(secondNode).forEach(e -> {
            if (e.equals(edge)) this.adjacencyList.get(secondNode).remove(e);
        });
    }

    /**
     * Removes an edge between two nodes
     * @param edge The edge to be removed
     */
    public void removeEdge(Edge edge) {
        try {
            this.removeEdge(edge.getNodes()[0], edge.getNodes()[1], edge.getTransportType());
        } catch (InvalidNode ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gets the name of the graph
     * @return The graph's name
     */
    public String getName() {
        return this.name;
    }

    public Node findNode(int id) throws InvalidNode {
        for (Node node : this.adjacencyList.keySet()) {
            if (node.getID() == id) {
                return node;
            }
        }
        throw new InvalidNode("no node with id " + id + " found");
    }

    /**
     * Get all edges of a node
     * @param id Node id
     * @return Returns a list of edges
     * @throws InvalidNode Is thrown when no node with the id exists
     */
    public List<Edge> getEdges(int id) throws InvalidNode {
        return this.adjacencyList.get(this.findNode(id));
    }

    /**
     * Gets all edges of a node
     * @param node Target node
     * @return Returns list of nodes that are connected to the target node
     */
    public List<Edge> getEdges(Node node) {
        return this.adjacencyList.get(node);
    }

}
