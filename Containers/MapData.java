package cyc.Containers;

import java.util.LinkedHashMap;


public class MapData<K,V> extends LinkedHashMap<K,V> {
    public MapData(Generator<K>key,Generator<V>val,int num)
    {
        for(int i=0;i<num;i++)
            put(key.next(), val.next());
    }
    public MapData(Generator<Pair<K,V>>keyVal,int num)
    {
        for(int i=0;i<num;i++)
        {
            Pair<K,V>p= keyVal.next();
            put(p.key,p.val);
        }
    }
    public MapData(Generator<K>key,V val,int num)
    {
        for(int i=0;i<num;i++)
        {
            put(key.next(),val);
        }
    }
    public MapData(Iterable<K>genK,Generator<V> val)
    {
        for(K key:genK)
        {
            put(key, val.next());
        }
    }
    public MapData(Iterable<K>genK,V val)
    {
        for(K key:genK)
        {
            put(key, val);
        }
    }
    public static<K,V> MapData<K,V> map(Generator<K>key,Generator<V>val,int num)
    {
        return new MapData<>(key,val,num);
    }
    public static<K,V> MapData<K,V> map(Generator<Pair<K,V>>keyVal,int num)
    {
        return new MapData<>(keyVal,num);
    }
    public static<K,V> MapData<K,V> map(Generator<K>key,V val,int num)
    {
        return new MapData<>(key,val,num);
    }
    public static<K,V> MapData<K,V> map(Iterable<K>key,Generator<V>val)
    {
        return new MapData<>(key,val);
    }
    public static<K,V> MapData<K,V> map(Iterable<K>key,V val)
    {
        return new MapData<>(key,val);
    }

}
