package cyc.Containers;
import java.util.*;

import static cyc.Utils.*;
public class Utilities {
    static List<String>list= Arrays.asList("one two three four five six one".split(" "));
    public static void main(String[]args)
    {
        print(list);// one two ... one
        // If there is no public element in two collection ,return true
        print("'list' disjoint (Four)?:"+
                Collections.disjoint(list, Collections.singletonList("four")));//false
        print("max: "+Collections.max(list));//two
        print("min: "+Collections.min(list));//five
        print("max w/ comparator: "+Collections.max(list,String.CASE_INSENSITIVE_ORDER));
        print("min w/ comparator: "+Collections.min(list,String.CASE_INSENSITIVE_ORDER));
        List<String>sublist= Arrays.asList("four five six".split(" "));
        print("indexOfSubList:  "+Collections.indexOfSubList(list, sublist));
        print("lastIndexOfSubList: "+Collections.lastIndexOfSubList(list, sublist));
        Collections.replaceAll(list, "one", "Hi");
        print("replaceAll: "+list);
        Collections.reverse(list);
        print("reverse: "+list);
        Collections.rotate(list, 3);
        print("rotate: "+list);
        List<String>source=
                Arrays.asList("int the matrix".split(" "));
        Collections.copy(list, source);
        print("copy:"+list);
        Collections.swap(list, 0, list.size()-1);
        print("swap: "+list);
        Collections.shuffle(list,new Random(47));
        print("shuffle: "+list);
        Collections.fill(list, "pop");
        print("fill: "+list);
        print("frequency of 'pop': "+Collections.frequency(list, "pop"));
        List<String>dups=Collections.nCopies(3, "snap");
        print("dups: "+dups);
        print("'list' disjoint 'dups'?: "+Collections.disjoint(list, dups));
        //return a Enumeration<T>
        Enumeration<String>e=Collections.enumeration(dups);
        Vector<String>v=new Vector<>();
        while(e.hasMoreElements())
            v.addElement(e.nextElement());
        ArrayList<String>arrayList=
                Collections.list(v.elements());
        print("arraylist: "+arrayList);
    }
}
