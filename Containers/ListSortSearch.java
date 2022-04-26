package cyc.Containers;

import java.util.*;

import static cyc.Utils.*;
public class ListSortSearch {
    public static void main(String[]args)
    {
        List<String>list=new ArrayList<>(Utilities.list);
        list.addAll(Utilities.list);
        print(list);
        Collections.shuffle(list,new Random(47));
        print("shuffle: "+list);
        // Use a ListIterator to trim off the last element
        ListIterator<String> it=list.listIterator(10);
        while(it.hasNext())
        {
            it.next();
            it.remove();
        }
        print("Trimmed: "+ list);
        Collections.sort(list);
        print("Sorted: "+list);
        String key=list.get(7);
        int index=Collections.binarySearch(list, key);
        print("location of "+key+" is "+index+
                ", list.get("+index+") ="+list.get(index));

    }
}
