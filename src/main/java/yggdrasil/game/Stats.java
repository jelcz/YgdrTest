package yggdrasil.game;

public class Stats {
    private int amount;
    private int extraLife;
    private boolean gameOver;

    public Stats() {
        this.amount = 0;
        this.extraLife = 0;
        this.gameOver = false;
    }

    public int getAmount() {
        return amount;
    }

    public int getExtraLife() {
        return extraLife;
    }

    public void addExtraLife() {
        extraLife++;
    }

    public void removeExtraLife() {
        extraLife--;
    }

    public void setGameOver(boolean option){
        gameOver = option;
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void addToAmount(int value) {
        amount += value;
    }
}
