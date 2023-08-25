package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class PaceCalculator {
    String distance;
    String hours;
    String minutes;
    String seconds;
}
