package cyc.Containers;

import java.util.*;

public class Country {
    public static final String[][]DATA={
    // Africa
            {"ALGERIA","Algiers"},{"ANGOLA","Luanda"},
    // Asia
            {"CHINA","Beijing"},{"JAPAN","Tokyo"}
    };
    private static class FlyweightMap
                      extends AbstractMap<String,String>
    {
        private static class Entry
             implements Map.Entry<String,String>
        {
            int index;
            Entry(int index){this.index=index;}

            @Override
            public boolean equals(Object o) {
                return DATA[index][0].equals(o);
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
            public String getKey()
            {
                return DATA[index][0];
            }
            public String getValue()
            {
                return DATA[index][1];
            }
            public String setValue(String val)
            {
                throw new UnsupportedOperationException();
            }
        }
        static class EntrySet
                    extends AbstractSet<Map.Entry<String,String>>
        {
            private int size;
            EntrySet(int size)
            {
                if(size<0)
                {
                    this.size=0;
                }
                else if(size> DATA.length)
                    this.size=DATA.length;
                else
                    this.size=size;
            }
            public int size() {return this.size;}
            private class Iter
            implements Iterator<Map.Entry<String,String>>
            {
                private Entry entry=new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index<size-1;
                }
                public Map.Entry<String,String>next()
                {
                    entry.index++;
                    return entry;
                }
                public void remove()
                {
                    throw new UnsupportedOperationException();
                }
            }
            public Iterator<Map.Entry<String,String>>iterator()
            {
                return new Iter();
            }
        }
        private static Set<Map.Entry<String,String>>entries=new EntrySet(DATA.length);
        public Set<Map.Entry<String,String>>entrySet()
        {
            return entries;
        }
    }
    static Map<String,String>select(int size)
    {
        return new FlyweightMap(){
            public Set<Map.Entry<String,String>>entrySet()
            {
                return new EntrySet(size);
            }
        };
    }
    static Map<String,String> map=new FlyweightMap();
    public static Map<String,String>capitals()
    {
        return map;
    }
    public static Map<String,String>capitals(int size)
    {
        return select(size);
    }

    @Override
    public String toString() {
        return map.toString();
    }

    static List<String>names=new ArrayList<String>(map.keySet());
    public static List<String>names(){return names;}
    public static List<String>names(int size){return new ArrayList<String>(select(size).keySet());}
    public static void main(String []args)
    {
        System.out.println(capitals(4));
        System.out.println(names(4));
        System.out.println(new HashMap<String,String>(capitals(4)));
    }
}
