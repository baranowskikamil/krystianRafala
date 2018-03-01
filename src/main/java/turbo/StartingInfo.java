package turbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StartingInfo {

    private Integer row;
    private Integer column;
    private Integer fleet;
    private Integer rides;
    private Integer bonus;
    private Integer time;
}
