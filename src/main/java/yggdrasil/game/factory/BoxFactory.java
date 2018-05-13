package yggdrasil.game.factory;

import yggdrasil.game.contents.Box;
import yggdrasil.game.contents.Money;
import yggdrasil.game.contents.Sign;
import yggdrasil.game.contents.SignType;
import yggdrasil.game.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class BoxFactory {
    public List<Box> getGameSet() {
        List<Box> boxes = new ArrayList<>();
        IntStream.range(0, Settings.NUMBER_OF_AMOUNT_100_BOXES).forEach(i -> boxes.add(new Money(100)));
        IntStream.range(0, Settings.NUMBER_OF_AMOUNT_20_BOXES).forEach(i -> boxes.add(new Money(20)));
        IntStream.range(0, Settings.NUMBER_OF_AMOUNT_5_BOXES).forEach(i -> boxes.add(new Money(5)));

        IntStream.range(0, Settings.NUMBER_OF_SIGN_EXTRA_LIFE_BOXES).forEach(i -> boxes.add(new Sign(SignType.EXTRA_LIFE)));

        IntStream.range(0, Settings.NUMBER_OF_SIGN_GAME_OVER_BOXES).forEach(i -> boxes.add(new Sign(SignType.GAME_OVER)));
        return boxes;
    }

    public List<Box> getFinalSet() {
        List<Box> boxes = new ArrayList<>();
        IntStream.range(0, Settings.NUMBER_OF_FINAL_AMOUNT_20_BOXES).forEach(i -> boxes.add(new Money(20)));
        IntStream.range(0, Settings.NUMBER_OF_FINAL_AMOUNT_10_BOXES).forEach(i -> boxes.add(new Money(10)));
        IntStream.range(0, Settings.NUMBER_OF_FINAL_AMOUNT_5_BOXES).forEach(i -> boxes.add(new Money(5)));

        IntStream.range(0, Settings.NUMBER_OF_FINAL_SIGN_SECOND_CHANCE).forEach(i -> boxes.add(new Sign(SignType.SECOND_CHANCE)));
        return boxes;
    }
}
