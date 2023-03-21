package model.graph.util;

import model.game.transportation.TransportationType;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private final int id;
    private final List<TransportationType> transportTypes;

    public Node(int id, List<TransportationType> transportTypes) {
        this.id = id;
        this.transportTypes = new ArrayList<>();
        this.transportTypes.addAll(transportTypes);
    }

    public int getID() {
        return this.id;
    }

    public boolean containsTransportType(TransportationType type) {
        return this.transportTypes.contains(type);
    }

    public List<TransportationType> getTransportTypes() {
        return new ArrayList<>(this.transportTypes);
    }

    public void addTransportType(TransportationType type) {
        this.transportTypes.add(type);
    }

    public void removeTransportType(TransportationType type) {
        this.transportTypes.remove(type);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node node)) {
            return false;
        }

        return node.getID() == this.id && node.getTransportTypes().equals(this.transportTypes);
    }

    @Override
    public String toString() {
        return Integer.toString(this.id);
    }

}
