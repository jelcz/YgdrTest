package yggdrasil;

import yggdrasil.game.contents.Box;
import yggdrasil.game.factory.BoxFactory;
import yggdrasil.game.Round;
import yggdrasil.game.player.Player;

import java.util.Collections;
import java.util.List;

public class LaunchService {
    private Round round;

    public LaunchService(Player player, BoxFactory boxFactory) {
        List<Box> gameBoxes = boxFactory.getGameSet();
        List<Box> finalBoxes = boxFactory.getFinalSet();

        Collections.shuffle(gameBoxes);
        Collections.shuffle(finalBoxes);

        this.round = new Round(player, gameBoxes, finalBoxes);
    }

    public int playTheGame() {
        return round.playRound();
    }
}
