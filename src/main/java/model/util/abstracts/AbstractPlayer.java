package model.util.abstracts;

import model.game.transportation.TransportationType;
import model.graph.util.Node;

import java.util.List;

public abstract class AbstractPlayer {

    protected int ID;
    protected Node lastKnownLocation;
    protected List<TransportationType> transportationHistory;

    public void addMovement(TransportationType type) {
        this.transportationHistory.add(type);
    }

    public List<TransportationType> getTransportationHistory() {
        return this.transportationHistory;
    }

    public int getID() {
        return this.ID;
    }

    /**
     * Returns the last known location. For a normal player this is his current location.
     * @return Returns a node
     */
    public Node getLastKnownLocation() {
        return this.lastKnownLocation;
    }
}
