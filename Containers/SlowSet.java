package cyc.Containers;

import java.util.*;

public class SlowSet<T>extends AbstractSet {
    protected List<T> list=new LinkedList<>();
    @Override
    public boolean add(Object o) {
        if(list.contains(o))
            return false;
        list.add((T)o);
        return true;

    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }
    public static void main(String[]args)
    {
        SlowSet<Integer>slowSet=new SlowSet<>();
        Collections.addAll(slowSet, 1,2,3,4,5);
        Iterator<Integer>i= slowSet.iterator();
        while(i.hasNext())
            System.out.println(i.next());
    }
}
