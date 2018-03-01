package turbo;

import javafx.util.Pair;
import turbo.parser.FileReader;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Qenlin on 01.03.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StartingInfo startingInfoByKamil = new FileReader("a_example.in").getStartingInfo();

        System.out.println(startingInfoByKamil);

        Integer time = 0;
        Integer t = 10;

        Ride ride1 = Ride.builder().earlierStart(2).latestFinish(9).startPoint(new Pair<>(0, 0)).finishPoint(new Pair<>(1, 3)).build();
        Ride ride2 = Ride.builder().earlierStart(0).latestFinish(9).startPoint(new Pair<>(1, 2)).finishPoint(new Pair<>(1, 0)).build();
        Ride ride3 = Ride.builder().earlierStart(0).latestFinish(9).startPoint(new Pair<>(2, 0)).finishPoint(new Pair<>(2, 2)).build();

        StartingInfo startinginfo = StartingInfo.builder().bonus(2).column(4).fleet(2).numberOfRides(3).row(3).time(10).rides(Arrays.asList(ride1,ride2,ride3)).build();

        while (time < t) {

        }
    }
}
