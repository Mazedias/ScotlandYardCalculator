package model.graph.util;

import model.game.transportation.TransportationType;
import model.util.exceptions.InvalidNode;

public class Edge {

    private final Node firstNode;
    private final Node secondNode;
    private final TransportationType transportType;

    public Edge(Node firstNode, Node secondNode, TransportationType transportationTypes) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.transportType = transportationTypes;
    }

    public TransportationType getTransportType() {
        return this.transportType;
    }

    /**
     * Returns the destination of the edge
     * @param startNode Start node of the edge
     * @return Returns the destination node of this edge
     * @throws InvalidNode Is thrown when this edge does not start/end at the given startNode
     */
    public Node findTarget(Node startNode) throws InvalidNode {
        if (startNode.equals(firstNode)) {
            return this.secondNode;
        } else if (startNode.equals(secondNode)) {
            return this.firstNode;
        }
        throw new InvalidNode("this edge does not start/end at the node " + startNode.toString());
    }

    public Node[] getNodes() {
        return new Node[]{this.firstNode, this.secondNode};
    }

    /**
     * Two edges are equal if they connect the same nodes
     * @param o Object to compare with
     * @return Returns whether the compared objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Edge edge)) {
            return false;
        }

        return ((edge.getNodes()[0].equals(this.firstNode) && edge.getNodes()[1].equals(this.secondNode))
                || (edge.getNodes()[0].equals(this.secondNode) && edge.getNodes()[1].equals(this.firstNode)))
                && edge.getTransportType().equals(this.transportType);
    }

}
