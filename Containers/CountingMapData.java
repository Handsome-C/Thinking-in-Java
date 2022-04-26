package cyc.Containers;

import java.util.*;

public class CountingMapData
extends AbstractMap<Integer,String>
{
    static private int size;
    private static String chars[]=
            "A B C D E F G H I J K L M N O P Q R T U V W X Y Z".split(" ");
    public CountingMapData(int size){this.size=size;}
    static class Entry
    implements Map.Entry<Integer,String>
    {
        private int index;
        Entry(int index){this.index=index;}

        @Override
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }
        public Integer getKey(){return Integer.valueOf(index);}
        public String getValue()
        {
            return chars[index% chars.length]+" "+Integer.toString(index/ chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }
    static class EntrySet
    extends AbstractSet<Map.Entry<Integer,String>>
    {
        int length;
        EntrySet(int size){length=size;}
        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iterator<Map.Entry<Integer, String>>() {
                private int i=0;
                @Override
                public boolean hasNext() {
                    return i<length;
                }

                @Override
                public Map.Entry<Integer, String> next() {
                    return new Entry(i++);
                }
            };
        }

        @Override
        public int size() {
            return length;
        }
    }
    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        Set<Map.Entry<Integer,String>>entries=new EntrySet(size);
        return entries;
    }
    public static void main(String[]args)
    {
        System.out.println(new CountingMapData(60));
    }
}
