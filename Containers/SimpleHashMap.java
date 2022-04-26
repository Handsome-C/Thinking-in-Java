package cyc.Containers;

import java.util.*;

import  static cyc.Utils.*;
public class SimpleHashMap<K,V>extends AbstractMap<K,V> {

    static final int SIZE=997;

    LinkedList<MapEntry<K,V>>[]buckets=
            new LinkedList[SIZE];
    public V put(K key,V value)
    {
        V oldValue=null;
        int index=Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null)
            buckets[index]=new LinkedList<>();
        LinkedList<MapEntry<K,V>>bucket=buckets[index];
        MapEntry<K,V>pair=new MapEntry<>(key, value);
        boolean found=false;
        ListIterator<MapEntry<K,V>>listIterator=bucket.listIterator();
        while(listIterator.hasNext())
        {
            MapEntry<K,V>iPair=listIterator.next();
            if(iPair.getKey().equals(key))
            {
                oldValue=iPair.getValue();
                listIterator.set(pair);// replace the old with the new
                found=true;
                break;
            }
        }
        if(!found)
        {
            bucket.add(pair);
        }
        return oldValue;
    }
    public V get(Object key)
    {
        int index=Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null)return null;
        for(MapEntry<K,V>mapEntry:buckets[index])
        {
            if(mapEntry.getKey().equals(key))
                return mapEntry.getValue();
        }
        return null;
    }
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>>set=new HashSet<>();
        for(LinkedList<MapEntry<K,V>>bucket:buckets)
        {
            if(bucket==null)continue;
            for(MapEntry<K,V>mapEntry:bucket)
                set.add(mapEntry);
        }
        return set;
    }

    @Override
    public V remove(Object key) {
        V oldValue=null;
        int index=Math.abs(key.hashCode())%SIZE;
        if(buckets[index]==null)return null;
        for(int i=0;i<buckets[index].size();i++)
        {
            if(buckets[index].get(i).getKey().equals(key))
            {
                oldValue=buckets[index].get(i).getValue();
                buckets[index].remove(i);
            }
        }
        return oldValue;
    }

    @Override
    public void clear() {
        for(int i=0;i< buckets.length;i++)
            buckets[i].clear();
    }

    public static void main(String[]args)
    {
        SimpleHashMap<String,String>m=new SimpleHashMap<>();
        m.putAll(Country.capitals(25));
        System.out.println(m);
        System.out.println(m.entrySet());
    }
}
