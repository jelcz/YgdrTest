package yggdrasil.game.player;

import yggdrasil.game.Settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class AutomaticPlayer extends Player {
    private List<Integer> moves = new ArrayList<>();
    private List<Integer> finalMoves = new ArrayList<>();

    public AutomaticPlayer() {
        super();
        IntStream.range(0, Settings.NUMBER_OF_BOXES).forEach(i -> moves.add(i));
        Collections.shuffle(moves);
        IntStream.range(0, Settings.NUMBER_OF_FINAL_BOXES).forEach(i -> finalMoves.add(i));
        Collections.shuffle(finalMoves);
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
