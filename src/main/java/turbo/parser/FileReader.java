package turbo.parser;

import javafx.util.Pair;
import turbo.Ride;
import turbo.StartingInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Qenlin on 01.03.2018.
 */
public class FileReader {
    private StartingInfo startingInfo = new StartingInfo();

    public StartingInfo getStartingInfo() {
        return startingInfo;
    }

    private List<Ride> rides = new LinkedList<Ride>();

    public FileReader(String fileName) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        InputStreamReader streamReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(streamReader);

        createStartingInfo(reader.readLine());


        for (String line; (line = reader.readLine()) != null; ) {
            Ride ride = createRide(line);
            System.out.println(ride);
            rides.add(ride);
        }

        startingInfo.setRides(rides);

    }

    private void createStartingInfo(String firstLine) throws IOException {
        String[] split = firstLine.split(" ");
        startingInfo = new StartingInfo(new Integer(split[0]), new Integer(split[1]), new Integer(split[2]),
                new Integer(split[3]), new Integer(split[4]), new Integer(split[5]), null);
        System.out.println(startingInfo.toString());
    }

    private Ride createRide(String firstLine) throws IOException {
        String[] split = firstLine.split(" ");
        Ride ride = new Ride(new Integer(split[4]),
                new Integer(split[5]),
                new Pair<Integer, Integer>(new Integer(split[0]), new Integer(split[1])),
                new Pair<Integer, Integer>(new Integer(split[2]), new Integer(split[3])));
        return ride;
    }
}
