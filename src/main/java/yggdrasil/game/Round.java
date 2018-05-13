package yggdrasil.game;

import yggdrasil.game.contents.Box;
import yggdrasil.game.player.Player;

import java.util.List;

public class Round {
    private List<Box> gameBoxes;
    private List<Box> finalBoxes;
    private Player player;

    public Round(Player player, List<Box> gameBoxes, List<Box> finalBoxes) {
        this.player = player;
        this.gameBoxes = gameBoxes;
        this.finalBoxes = finalBoxes;
    }

    public int playRound() {
        while (!player.getStats().getGameOver()) {
            openGameBox();
            if (player.getStats().getGameOver()) {
                openFinalBox();
            }
        }

        return player.getStats().getAmount();
    }

    private void openGameBox() {
        int nextChoiceIndex = player.getNextGameChoice();
        openBox(nextChoiceIndex, gameBoxes);
    }

    private void openFinalBox() {
        int finalChoiceIndex = player.getNextFinalReward();
        openBox(finalChoiceIndex, finalBoxes);
    }

    private void openBox(int nextChoiceIndex, List<Box> gameBoxes) {
        Box chosenBox = gameBoxes.get(nextChoiceIndex);
        Stats statsBeforeRound = player.getStats();
        Stats statsAfterRound = chosenBox.consume(statsBeforeRound);
        player.setStats(statsAfterRound);
    }
}
