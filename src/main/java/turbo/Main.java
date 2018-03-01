package turbo;

import javafx.util.Pair;

/**
 * Created by Qenlin on 01.03.2018.
 */
public class Main {
    public static void main(String[] args) {

        Integer time = 0;
        Integer t = 10;

        Ride wojtek = Ride.builder().earlierStart(2).latestFinish(9).startPoint(new Pair<>(0, 0)).finishPoint(new Pair<>(1, 3)).build();

        while (time < t) {

        }
    }
}
