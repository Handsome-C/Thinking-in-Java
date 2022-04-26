package cyc.Containers;

import java.util.Iterator;
import java.util.TreeMap;
import static cyc.Utils.*;
public class SortMapDemo {
    public static void main(String[]args)
    {
        TreeMap<Integer,String>map=new TreeMap<>(new CountingMapData(10));
        print(map);
        Integer  low=map.firstKey();
        Integer high=map.lastKey();
        print(low);
        print(high);
        Iterator<Integer>it=map.keySet().iterator();
        for(int i=0;i<=6;i++)
        {
            if(i==3)low=it.next();
            if(i==6)high=it.next();
            else it.next();
        }
        print(low);
        print(high);
        print(map.subMap(low, high));
        print(map.headMap(high));
        print(map.tailMap(low));
    }
}
