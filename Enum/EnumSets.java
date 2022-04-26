package cyc.Enum;

import java.util.EnumSet;
import static cyc.Utils.*;
public class EnumSets {
    public static void main(String[]args)
    {
        EnumSet<AlarmPoints>points=EnumSet.noneOf(AlarmPoints.class);// Empty set
        points.add(AlarmPoints.BATHROOM);
        print(points);
        points.addAll(EnumSet.of(AlarmPoints.START1,AlarmPoints.START2,AlarmPoints.KITCHEN));
        print(points);
        points=EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(AlarmPoints.START1,AlarmPoints.START2,AlarmPoints.KITCHEN));
        print(points);
        points.removeAll(EnumSet.range(AlarmPoints.OFFICE1,AlarmPoints.OFFICE4));
        print(points);
        points=EnumSet.complementOf(points);
        print(points);
    }
}
