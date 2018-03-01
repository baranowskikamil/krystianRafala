package turbo;

import javafx.util.Pair;

/**
 * Created by Qenlin on 01.03.2018.
 */
public class Main {
    public static void main(String[] args) {

        Integer time = 0;
        Integer t = 10;

        Ride ride1 = Ride.builder().earlierStart(2).latestFinish(9).startPoint(new Pair<>(0, 0)).finishPoint(new Pair<>(1, 3)).build();
        Ride ride2 = Ride.builder().earlierStart(0).latestFinish(9).startPoint(new Pair<>(1, 2)).finishPoint(new Pair<>(1, 0)).build();
        Ride ride3 = Ride.builder().earlierStart(0).latestFinish(9).startPoint(new Pair<>(2, 0)).finishPoint(new Pair<>(2, 2)).build();


        while (time < t) {

        }
    }
}
