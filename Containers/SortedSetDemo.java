package cyc.Containers;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import static cyc.Utils.*;
public class SortedSetDemo {
    public static void main(String[]args)
    {
        SortedSet<String>sortedSet=new TreeSet<>();
        Collections.addAll(sortedSet, "1 2 3 4 5 6 7".split(" "));
        print(sortedSet);
        String low=sortedSet.first();
        String high=sortedSet.last();
        print(low);
        print(high);
        Iterator<String> it= sortedSet.iterator();
        print(sortedSet.subSet(low, high));
        print(sortedSet.headSet(high));
        print(sortedSet.tailSet(low));
    }
}
