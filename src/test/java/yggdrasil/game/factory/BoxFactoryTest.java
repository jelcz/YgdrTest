package yggdrasil.game.factory;

import yggdrasil.game.contents.Box;
import yggdrasil.game.Settings;
import org.junit.Assert;
import org.junit.Test;
import yggdrasil.game.factory.BoxFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BoxFactoryTest
{
    @Test
    public void shouldProduceCorrectAmountOfRoundBoxes() {
        // Given
        BoxFactory factory = new BoxFactory();
        // When
        List<Box> boxList = factory.getGameSet();
        // Then
        Assert.assertTrue(boxList.size() == Settings.NUMBER_OF_BOXES);
    }

    @Test
    public void shouldProduceCorrectAmountOfFinalBoxes() {
        // Given
        BoxFactory factory = new BoxFactory();
        // When
        List<Box> boxList = factory.getFinalSet();
        // Then
        Assert.assertTrue(boxList.size() == Settings.NUMBER_OF_FINAL_BOXES);
    }

}
