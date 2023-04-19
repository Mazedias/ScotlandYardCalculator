package model.game;

import model.game.player.MrX;
import model.game.player.Player;
import model.graph.util.Node;

import java.util.ArrayList;
import java.util.List;

public class GameHandler {

    private final List<Player> players;
    private MrX mrX;
    private int idCounter;


    public GameHandler() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Node location) {
        this.players.add(new Player(this.idCounter, location));
        this.idCounter++;
    }

    public void addMrX(Node location) {
        if (this.mrX != null) {
            this.mrX = new MrX(0, location);
            this.idCounter++;
        }
    }


}
