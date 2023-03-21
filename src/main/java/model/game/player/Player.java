package model.game.player;

import model.game.transportation.TransportationType;
import model.graph.util.Node;
import model.util.abstracts.AbstractPlayer;

import java.util.ArrayList;
import java.util.List;

public class Player extends AbstractPlayer {

    private final List<Node> movementHistory;

    public Player(int id, Node startLocation) {
        this.ID = id;

        this.lastKnownLocation = startLocation;

        this.transportationHistory = new ArrayList<>();
        this.movementHistory = new ArrayList<>();
    }

    public List<Node> getMovementHistory() {
        return movementHistory;
    }

    /**
     * Add a new movement to this player
     * @param type Type of transportation used by the player
     * @param destination Destination node
     */
    public void addMovement(TransportationType type, Node destination) {
        this.transportationHistory.add(type);
        this.movementHistory.add(destination);

        this.lastKnownLocation = destination;
    }

}
