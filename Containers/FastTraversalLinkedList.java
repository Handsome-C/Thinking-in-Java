package cyc.Containers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FastTraversalLinkedList<T> {
    LinkedList<T>linkedList=new LinkedList<>();
    ArrayList<T>arrayList=new ArrayList<>();
    public T get(int index)
    {
        return arrayList.get(index);
    }
    public void insert(int index,T value)
    {
        linkedList.add(index, value);
        arrayList=new ArrayList<>(linkedList);
    }
    public void remove(int index)
    {
        linkedList.remove(index);
        arrayList=new ArrayList<>(linkedList);
    }
}
