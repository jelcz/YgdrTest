package yggdrasil.game.player;

import yggdrasil.game.Settings;
import org.junit.Assert;
import org.junit.Test;
import yggdrasil.game.player.AutomaticPlayer;
import yggdrasil.game.player.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class AutomaticPlayerTest {
    @Test
    public void shouldReturnCorrectAmountMoves() {
        // Given
        Player player = new AutomaticPlayer();
        List<Integer> moves = new ArrayList<>();
        // When
        IntStream.range(0, Settings.NUMBER_OF_BOXES).forEach(i -> moves.add(player.getNextGameChoice()));
        // Then
        Assert.assertTrue(moves.size() == 12);
    }

    @Test
    public void shouldProduceNotDuplicatedRoundMoves() {
        // Given
        Player player = new AutomaticPlayer();
        List<Integer> moves = new ArrayList<>();
        Set<Integer> movesSet = new HashSet<>();
        // When
        IntStream.range(0, Settings.NUMBER_OF_BOXES).forEach(i -> {
                int nextChoice = player.getNextGameChoice();
                moves.add(nextChoice);
                movesSet.add(nextChoice);
            }
        );
        // Then
        Assert.assertTrue(moves.size() == movesSet.size());
    }

    @Test
    public void shouldProduceNotDuplicatedFinalMoves() {
        // Given
        Player player = new AutomaticPlayer();
        List<Integer> moves = new ArrayList<>();
        Set<Integer> movesSet = new HashSet<>();
        // When
        IntStream.range(0, Settings.NUMBER_OF_FINAL_BOXES).forEach(i -> {
                int nextChoice = player.getNextFinalReward();
                moves.add(nextChoice);
                movesSet.add(nextChoice);
            }
        );
        // Then
        Assert.assertTrue(moves.size() == movesSet.size());
    }
}
