package yggdrasil.game;

import yggdrasil.game.contents.Box;
import yggdrasil.game.contents.Money;
import yggdrasil.game.contents.Sign;
import yggdrasil.game.contents.SignType;
import yggdrasil.game.Round;
import yggdrasil.game.player.Player;
import yggdrasil.game.utils.TestPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RoundTest {

    @Test
    public void shouldReturnCorrectAmountAfterRound() {
        // Given
        Round round = getSampleRound();
        // When
        int score = round.playRound();
        // Then
        Assert.assertTrue(score == 155);
    }

    private Round getSampleRound() {
        List<Box> gameBoxes = getSampleGameBoxes();
        List<Box> finalBoxes = getSampleFinalBoxes();

        List<Integer> gameMoves = getSampleGameMoves();
        List<Integer> finalMoves = getSampleFinalMoves();

        Player testPlayer = new TestPlayer(gameMoves, finalMoves);

        return new Round(testPlayer, gameBoxes, finalBoxes);
    }

    private List<Integer> getSampleFinalMoves() {
        List<Integer> finalMoves = new ArrayList<>();
        IntStream.range(0, 2).forEach(finalMoves::add);
        return finalMoves;
    }

    private List<Integer> getSampleGameMoves() {
        List<Integer> gameMoves = new ArrayList<>();
        IntStream.range(0, 8).forEach(gameMoves::add);
        return gameMoves;
    }

    private List<Box> getSampleFinalBoxes() {
        List<Box> finalBoxes = new ArrayList<>();
        finalBoxes.add(new Sign(SignType.SECOND_CHANCE));
        finalBoxes.add(new Money(10));
        return finalBoxes;
    }

    private List<Box> getSampleGameBoxes() {
        List<Box> gameBoxes = new ArrayList<>();
        gameBoxes.add(new Money(100));
        gameBoxes.add(new Money(20));
        gameBoxes.add(new Sign(SignType.EXTRA_LIFE));
        gameBoxes.add(new Sign(SignType.GAME_OVER));
        gameBoxes.add(new Money(5));
        gameBoxes.add(new Sign(SignType.GAME_OVER));
        gameBoxes.add(new Money(20));
        gameBoxes.add(new Sign(SignType.GAME_OVER));
        return gameBoxes;
    }

}
