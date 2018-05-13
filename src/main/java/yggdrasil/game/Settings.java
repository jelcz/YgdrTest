package yggdrasil.game;

public class Settings {
    public static final int NUMBER_OF_AMOUNT_100_BOXES = 1;
    public static final int NUMBER_OF_AMOUNT_20_BOXES = 2;
    public static final int NUMBER_OF_AMOUNT_5_BOXES = 5;
    public static final int NUMBER_OF_SIGN_EXTRA_LIFE_BOXES = 1;
    public static final int NUMBER_OF_SIGN_GAME_OVER_BOXES = 3;

    public static final int NUMBER_OF_BOXES =
        NUMBER_OF_AMOUNT_100_BOXES +
        NUMBER_OF_AMOUNT_20_BOXES +
        NUMBER_OF_AMOUNT_5_BOXES +
        NUMBER_OF_SIGN_EXTRA_LIFE_BOXES +
        NUMBER_OF_SIGN_GAME_OVER_BOXES;

    public static final int NUMBER_OF_FINAL_AMOUNT_20_BOXES = 1;
    public static final int NUMBER_OF_FINAL_AMOUNT_10_BOXES = 1;
    public static final int NUMBER_OF_FINAL_AMOUNT_5_BOXES = 1;
    public static final int NUMBER_OF_FINAL_SIGN_SECOND_CHANCE = 1;

    public static final int NUMBER_OF_FINAL_BOXES =
        NUMBER_OF_FINAL_AMOUNT_20_BOXES +
        NUMBER_OF_FINAL_AMOUNT_10_BOXES +
        NUMBER_OF_FINAL_AMOUNT_5_BOXES +
        NUMBER_OF_FINAL_SIGN_SECOND_CHANCE;
}
