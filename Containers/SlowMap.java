package cyc.Containers;

import java.util.*;

public class SlowMap <K,V> extends AbstractMap<K,V> {
    static class MPair<K,V>
    {
        MPair(){}
        MPair(K key,V value)
        {
            this.key=key;
            this.value=value;
        }
        K key;
        V value;
    }
    public List<MPair<K,V>> data=new ArrayList<>();

    public V put(K key,V value)
    {
        V oldValue=null;
        MPair<K,V> mPair=new MPair(key,value);
        for(int i=0;i<data.size();i++)
        {
            if(data.get(i).key.equals(key))
            {
                oldValue=data.get(i).value;
                data.set(i,mPair);
                return oldValue;
            }
        }
        data.add(mPair);
        return null;
    }
    public V get(Object key)
    {
        for(int i=0;i<data.size();i++)
        {
            if(data.get(i).key.equals(key))
                return data.get(i).value;
        }
        return null;
    }
    class MapEntry<K,V> implements Map.Entry<K,V>
    {
        K key;
        V value;
        public MapEntry(K key,V value)
        {
            this.key=key;
            this.value=value;
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value=value;
        }
        public String toString()
        {
            return "Key:"+key+"#value:"+value;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof MapEntry)
            {
                MapEntry mapEntry=(MapEntry)o;
                return (key==null?false:key.equals(mapEntry.getKey()))&&
                        (value==null?false:value.equals(mapEntry.getValue()));
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (key==null?0:key.hashCode())^(value==null?0:value.hashCode());
        }
    }
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>>set=new HashSet<>();
        Iterator<MPair<K,V>>im=data.iterator();
        while(im.hasNext())
        {
            set.add(new MapEntry<>(im.next().key, im.next().value));
        }
        return set;
    }
    public static void main(String[]args)
    {
        SlowMap<String,String>m=new SlowMap<>();
        m.putAll(Country.capitals(15));
        System.out.println(m);
        System.out.println(m.entrySet());
    }
}
