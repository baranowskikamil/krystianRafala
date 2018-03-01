import javafx.util.Pair;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Qenlin on 01.03.2018.
 */
@Getter
@Setter
@AllArgsConstructor
public class Ride {
    private Integer earlierStart;
    private Integer latestFinish;
    private Pair<Integer, Integer> startPoint;
    private Pair<Integer, Integer> finishPoint;

    public Integer getDistance(){
        return Math.abs(startPoint.getKey() - finishPoint.getKey())
                + Math.abs(startPoint.getValue() - finishPoint.getValue());
    }
}
