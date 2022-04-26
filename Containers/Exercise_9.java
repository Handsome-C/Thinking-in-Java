package cyc.Containers;

import cyc.Arrays.RandomGenerator;
import cyc.template.Generators;

import java.util.SortedSet;
import java.util.TreeSet;

public class Exercise_9 {
    public static void main(String[]args)
    {
        SortedSet<String>treeSet=new TreeSet<>();
        for(int i=0;i<10;i++)
            treeSet.add(new RandomGenerator.RandomString().next());
        System.out.println(treeSet);
    }
}
