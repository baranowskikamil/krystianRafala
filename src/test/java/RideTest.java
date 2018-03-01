import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Qenlin on 01.03.2018.
 */

public class RideTest {

    @Test
    public void testGetDistanceInSamePosition() {
        Ride ride = new Ride(0, 0,
                new Pair<Integer, Integer>(0, 0),
                new Pair<Integer, Integer>(0, 0));

        Assert.assertEquals(new Integer(0), ride.getDistance());
    }

    @Test
    public void testGetDistanceInDifferentPosition() {
        Ride ride = new Ride(0, 0,
                new Pair<Integer, Integer>(1, 1),
                new Pair<Integer, Integer>(0, 0));

        Assert.assertEquals(new Integer(2), ride.getDistance());
    }


    @Test
    public void testGetDistanceInDifferentPosition1() {
        Ride ride = new Ride(0, 0,
                new Pair<Integer, Integer>(1, 0),
                new Pair<Integer, Integer>(1, 5));

        Assert.assertEquals(new Integer(5), ride.getDistance());
    }

    @Test
    public void testGetDistanceInDifferentPosition2() {
        Ride ride = new Ride(0, 0,
                new Pair<Integer, Integer>(2, 2),
                new Pair<Integer, Integer>(1, 5));

        Assert.assertEquals(new Integer(4), ride.getDistance());
    }
}
