package cyc.Containers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class MySortedSet<T extends Comparable<T>> {
    private LinkedList<T> linkedList = new LinkedList<>();

    public void add(T element) {
        if (linkedList.size() == 0)
            linkedList.add(element);
        else {
            int i=linkedList.size()-1;
            for(;i>=0;i--)
            {
                if(element.compareTo(linkedList.get(i))==-1)
                    break;
            }
            linkedList.add(i+1,element);
        }
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

    public static void main(String[] args)
    {
        Random r=new Random(47);
        MySortedSet<Integer> mySortedSet=new MySortedSet<>();
        for(int i=0;i<10;i++)
            mySortedSet.add(r.nextInt(100));
        System.out.println(mySortedSet);
    }
}
