package cyc.Containers;

import java.util.HashSet;
import java.util.Set;

public class CollectionDataTest {
    public static class Government
                        implements Generator<String>
    {
        private String[] foundation="strange women lying in pounds".split(" ");
        int i=0;
        @Override
        public String next() {
            return foundation[i++% foundation.length];
        }
    }
    public static void main(String[]args)
    {
        Set<String>hashset=new HashSet<>();
        hashset.addAll(CollectionData.list(new Government(),10));
        System.out.println(hashset);
    }
}
