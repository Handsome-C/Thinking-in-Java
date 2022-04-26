package cyc.Containers;

import java.util.*;

public class Exercise7 {
    public static void main(String []args)
    {
        ArrayList<Integer>arrayList=new ArrayList<>();
        Collections.addAll(arrayList, 1,3,5,7,9);
        LinkedList<Integer>linkedList=new LinkedList<>();
        Collections.addAll(linkedList,2,4,6,8,10);
        Iterator<Integer>it= arrayList.iterator();
        Iterator<Integer>it2=linkedList.iterator();
        while(it.hasNext())
            System.out.print(it.next());
        System.out.println();
        while(it2.hasNext())
            System.out.print(it2.next());
        System.out.println();
        ListIterator<Integer>listIterator= arrayList.listIterator();;
        int i=0;
        while(listIterator.hasNext())
        {
            linkedList.add(i,listIterator.next());
            i+=2;
        }
        System.out.println(linkedList);
    }
}
