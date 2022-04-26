package cyc.Containers;

import java.util.Arrays;
import java.util.HashMap;

public class AssociativeArray<K,V> {
    private Object[][]pairs;
    private int index;
    public AssociativeArray(int length)
    {
        pairs=new Object[length][2];
    }
    public void put(K key,V value)
    {
        if(index>= pairs.length)
            throw new IndexOutOfBoundsException();
        pairs[index++]=new Object[]{key,value};
    }
    public V get(K key)
    {
        for(int i=0;i<index;i++)
        {
            if(pairs[i][0].equals(key))
                return (V)pairs[i][1];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<index;i++)
        {
            builder.append(pairs[i][0].toString());
            builder.append(":");
            builder.append(pairs[i][1].toString());
            if(i<index-1)
                builder.append("\n");
        }
        return builder.toString();
    }
    public static void main(String[]args)
    {
        AssociativeArray<String,String>map=new AssociativeArray<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try
        {
            map.put("extra", "object");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Too many objects");
        }
        System.out.println(map);
        System.out.println(map.get("sky"));
        /**
         * Exercise12
         * */
        HashMap<String,String>hashMap=new HashMap<>();
        hashMap.put("sky", "blue");
        hashMap.put("grass", "green");
        hashMap.put("ocean", "dancing");
        hashMap.put("tree", "tall");
        hashMap.put("earth", "brown");
        hashMap.put("sun", "warm");
        System.out.println(hashMap);
    }
}
