package cyc.Containers;

import cyc.Arrays.CountingGenerator;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static cyc.Utils.*;
public class Maps {
    public static void printKeys(Map<Integer,String> map)
    {
        print("Size = "+map.size()+".");
        print("Keys: ");
        print(map.keySet());//Produce a set of the keys
    }
    public static void printKeys2(Map<Object,Object> map)
    {
        print("Size = "+map.size()+".");
        print("Keys: ");
        print(map.keySet());//Produce a set of the keys
    }
    public static void test(Map<Integer, String>map)
    {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        printKeys(map);
        printnb("Values: ");
        print(map.values());
        print(map);
        print("map.containKey(11): "+map.containsKey(11));
        print("map.get(11):"+map.get(11));
        print("map.containsValue(\"F 0\"):"+map.containsValue("F 0"));
        Integer key=map.keySet().iterator().next();
        print("first key in the map:"+key);
        printKeys(map);
        map.clear();
        print("map.isEmpty(): "+map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the Map.
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty():"+map.isEmpty());
    }
    public static void test2(Map<Object, Object>map)
    {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        printKeys2(map);
        printnb("Values: ");
        print(map.values());
        print(map);
        print("map.containKey(11): "+map.containsKey(11));
        print("map.get(11):"+map.get(11));
        print("map.containsValue(\"F 0\"):"+map.containsValue("F 0"));
        Object key=map.keySet().iterator().next();
        print("first key in the map:"+key);
        printKeys2(map);
        map.clear();
        print("map.isEmpty(): "+map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the Map.
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty():"+map.isEmpty());
    }
    public static void main(String[]args)
    {
        test2(new Properties());
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
        test(new IdentityHashMap<>());
        test(new ConcurrentHashMap<>());
        test(new WeakHashMap<>());
    }
}
