package cyc.Containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Exercise1 {
    public static void main(String[]args)
    {
        List<Country>countries=new ArrayList<>();
        List<Country>countries1=new LinkedList<>();
        for(int i=0;i<10;i++)
        {
            countries.add(new Country());
            countries1.add(new Country());
        }
        System.out.println(countries);
        System.out.println(countries1);
        Collections.shuffle(countries);
        Collections.shuffle(countries1);
        System.out.println(countries);
        System.out.println(countries1);
    }
}
