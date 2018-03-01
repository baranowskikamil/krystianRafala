package turbo;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Qenlin on 01.03.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ride {
    private Integer earlierStart;
    private Integer latestFinish;
    private Pair<Integer, Integer> startPoint;
    private Pair<Integer, Integer> finishPoint;
    private RideStatus rideStatus;
    
    public Integer getDistance() {
        return Math.abs(startPoint.getKey() - finishPoint.getKey())
                + Math.abs(startPoint.getValue() - finishPoint.getValue());
    }
}
