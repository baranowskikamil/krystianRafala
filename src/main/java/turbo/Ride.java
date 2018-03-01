package turbo;


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
    private Position startPoint;
    private Position finishPoint;
    private RideStatus rideStatus;

    public Integer getDistance() {
        return Math.abs(startPoint.getXAxis() - finishPoint.getXAxis())
                + Math.abs(startPoint.getYAxis() - finishPoint.getYAxis());
    }
}
