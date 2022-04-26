package cyc.Containers;

import cyc.Arrays.CountingGenerator;

import java.util.LinkedHashMap;
import static cyc.Utils.*;
public class LinkedHashMapDemo {
    public static void main(String[]args)
    {
        LinkedHashMap<Integer,String>linkedHashMap=new LinkedHashMap<>(new CountingMapData(9));
        print(linkedHashMap);
        linkedHashMap=new LinkedHashMap<Integer, String>(16, 0.75f,true);
        linkedHashMap.putAll(new CountingMapData(9));
        print(linkedHashMap);
        for(int i=0;i<6;i++)
        {
            linkedHashMap.get(i);
        }
        print(linkedHashMap);
        linkedHashMap.get(0);
        print(linkedHashMap);
    }
}
