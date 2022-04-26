package cyc.Containers;

import java.util.*;

public class FailFast {
    public static void main(String[]args)
    {
        Collection<String>c=new ArrayList<>();
        Iterator<String>it=c.iterator();
        c.add("Object");
        try
        {
            String s= it.next();;
        }catch (ConcurrentModificationException e)
        {
            e.printStackTrace();
        }
    }
}
