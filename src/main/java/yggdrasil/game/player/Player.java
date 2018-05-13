package yggdrasil.game.player;

import yggdrasil.game.Stats;

public abstract class Player {
    private Stats stats;

    public Player(){
        this.stats = new Stats();
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public abstract int getNextGameChoice();
    public abstract int getNextFinalReward();
}
