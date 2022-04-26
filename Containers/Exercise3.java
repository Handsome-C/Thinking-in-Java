package cyc.Containers;

import java.util.*;

public class Exercise3 {
    public static void main(String[]args)
    {
        Set<Country>countries=new LinkedHashSet<>();
        List<Country>list=new LinkedList<>(Collections.nCopies(5,new Country()));
        countries.addAll(list);
        System.out.println(countries);

    }
}
