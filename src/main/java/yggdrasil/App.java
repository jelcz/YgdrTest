package yggdrasil;

import yggdrasil.game.factory.BoxFactory;
import yggdrasil.game.player.AutomaticPlayer;
import yggdrasil.game.player.Player;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class App {
    private final static int AMOUNT_OF_ROUNDS  = 10000000;

    private static BigDecimal sum = new BigDecimal(0);
    private static volatile BigDecimal sumPara1 = new BigDecimal(0);
    private static volatile BigDecimal sumPara2 = new BigDecimal(0);

    public static void main(String[] args) {
        runNonParallel();
        runParallel(); // I didn't have time to dig in deeply and finish parallel option,
        // sometimes it's slower than single-threaded
    }

    private static void runNonParallel() {
        long currentTime = System.currentTimeMillis();
        IntStream.rangeClosed(0, AMOUNT_OF_ROUNDS).forEach(i -> sum = sum.add(new BigDecimal(getResult())));
        long duration = System.currentTimeMillis() - currentTime;
        System.out.println("Duration: " + duration + " ms, result: " + sum
                .divide(new BigDecimal(AMOUNT_OF_ROUNDS)));
    }

    private static int getResult() {
        Player player = new AutomaticPlayer();
        BoxFactory boxFactory = new BoxFactory();
        LaunchService launchService = new LaunchService(player, boxFactory);
        return launchService.playTheGame();
    }

    private static void runParallel() {
        long currentTime = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> IntStream.rangeClosed(0, AMOUNT_OF_ROUNDS/2)
                        .forEach(j -> sumPara1 = sumPara1.add(new BigDecimal(getResult()))));
        Thread thread2 = new Thread(() -> IntStream.rangeClosed(0, AMOUNT_OF_ROUNDS/2)
                        .forEach(j -> sumPara2 = sumPara2.add(new BigDecimal(getResult()))));
        thread1.start();
        thread2.start();

        while (true) {
            try {
                thread1.join();
                thread2.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long duration = System.currentTimeMillis() - currentTime;
        sumPara1 = sumPara1.add(sumPara2);
        System.out.println("Duration parallel: " + duration + " ms, result: "
                + sumPara1.divide(new BigDecimal(AMOUNT_OF_ROUNDS)));
    }
}
