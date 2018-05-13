package yggdrasil.game.contents;

import yggdrasil.game.Stats;
import yggdrasil.game.contents.Box;
import yggdrasil.game.contents.Money;
import yggdrasil.game.contents.Sign;
import yggdrasil.game.contents.SignType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoxTest {
    private Stats stats;

    @Before
    public void refreshStats(){
        stats = new Stats();
    }

    @Test
    public void shouldAddCorrectAmountAfterConsuming() {
        // Given
        int moneyAmount = 20;
        Box money = new Money(moneyAmount);
        // When
        stats = money.consume(stats);
        // Then
        Assert.assertTrue(stats.getAmount() == moneyAmount);

        Assert.assertTrue(stats.getExtraLife() == 0);
        Assert.assertFalse(stats.getGameOver());
    }

    @Test
    public void shouldUpdateStatsAccordingToSignExtraLife() {
        // Given
        Box sign = new Sign(SignType.EXTRA_LIFE);
        // When
        stats = sign.consume(stats);
        // Then
        Assert.assertTrue(stats.getExtraLife() == 1);

        Assert.assertTrue(stats.getAmount() == 0);
        Assert.assertFalse(stats.getGameOver());
    }

    @Test
    public void shouldUpdateStatsAccordingToSignGameOver() {
        // Given
        Box sign = new Sign(SignType.GAME_OVER);
        // When
        stats = sign.consume(stats);
        // Then
        Assert.assertTrue(stats.getGameOver());

        Assert.assertTrue(stats.getExtraLife() == 0);
        Assert.assertTrue(stats.getAmount() == 0);
    }

    @Test
    public void shouldUpdateStatsAccordingToSignSecondChance() {
        // Given
        stats.setGameOver(true);
        Box sign = new Sign(SignType.SECOND_CHANCE);
        // When
        stats = sign.consume(stats);
        // Then
        Assert.assertFalse(stats.getGameOver());

        Assert.assertTrue(stats.getExtraLife() == 0);
        Assert.assertTrue(stats.getAmount() == 0);
    }
}
