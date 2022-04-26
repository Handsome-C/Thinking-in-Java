package cyc.Enum;

import java.util.EnumMap;
import java.util.Map;

interface Command{
    void action();
}
public class EnumMaps {
    public static void main(String[]args)
    {
    EnumMap<AlarmPoints,Command>map=
            new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
    map.put(AlarmPoints.KITCHEN, new Command() {
        @Override
        public void action() {
            System.out.println("Kitchen fire!");
        }
    });
    map.put(AlarmPoints.BATHROOM, new Command() {
        @Override
        public void action() {
            System.out.println("Bathroom alert!");
        }
    });
    for(Map.Entry<AlarmPoints,Command>entry:map.entrySet())
    {
        System.out.print(entry.getKey()+":");
        entry.getValue().action();
    }

    }
}
