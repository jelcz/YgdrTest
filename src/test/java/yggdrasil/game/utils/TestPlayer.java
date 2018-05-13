package yggdrasil.game.utils;

import yggdrasil.game.player.Player;

import java.util.ArrayList;
import java.util.List;

public class TestPlayer extends Player {
    private List<Integer> moves = new ArrayList<>();
    private List<Integer> finalMoves = new ArrayList<>();

    public TestPlayer(List<Integer> moves, List<Integer> finalMoves) {
        super();
        this.finalMoves = finalMoves;
        this.moves = moves;
    }
    @Override
    public int getNextGameChoice() {
        return moves.remove(0);
    }

    @Override
    public int getNextFinalReward() {
        return finalMoves.remove(0);
    }
}
