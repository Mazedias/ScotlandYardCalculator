package model.game.player;

import model.graph.util.Node;
import model.util.abstracts.AbstractPlayer;

import java.util.ArrayList;

public class MrX extends AbstractPlayer {

    private Node lastKnownLocation;

    public MrX (int id, Node location) {
        this.ID = id;
        this.lastKnownLocation = location;

        this.transportationHistory = new ArrayList<>();
    }
    public void setLastKnownLocation(Node location) {
        this.lastKnownLocation = location;
    }

    public Node getLastKnownLocation() {
        return this.lastKnownLocation;
    }

}
