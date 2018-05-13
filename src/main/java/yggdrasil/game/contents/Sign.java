package yggdrasil.game.contents;

import yggdrasil.game.Stats;

public class Sign implements Box {
    private SignType signType;

    public Sign(SignType signType) {
        this.signType = signType;
    }

    @Override
    public Stats consume(Stats stats) {
        switch(signType) {
            case EXTRA_LIFE:
                stats.addExtraLife();
                break;
            case GAME_OVER:
                if (stats.getExtraLife() > 0 ){
                    stats.removeExtraLife();
                } else {
                    stats.setGameOver(true);
                }
                break;
            case SECOND_CHANCE:
                stats.setGameOver(false);
            default:
            break;
        }
        return stats;
    }
}
