package yggdrasil.game.contents;

import yggdrasil.game.Stats;

public class Money implements Box {
    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public Stats consume(Stats stats) {
        stats.addToAmount(amount);
        return stats;
    }
}
