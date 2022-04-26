package cyc.Containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static cyc.Utils.*;
public class CollectionMethods {
  public static void main(String []args)
  {
      Collection<String> c=new ArrayList<String>();
      c.addAll(Country.names(4));
      c.add("ten");
      c.add("eleven");
      print(c);
      // Make an array from the List
      Object[]array= c.toArray();
      // Make a String array from the List
      String[]stringArray=c.toArray(new String[0]);
      // Find max and min elements; this means
      // different things depending on the way
      // the Comparable interface is implemented;
      print("Collections.max(c)=:"+ Collections.max(c));
      print("Collections.min(c)=:"+ Collections.min(c));
      // Add a Collection to another Collection
      Collection<String>cc=new ArrayList<>();
      cc.addAll(Country.names(6));
      c.addAll(cc);
      print(c);
      c.remove(Country.DATA[0][0]);
      print(c);
      c.remove(Country.DATA[1][0]);
      print(c);
      // Remove all components that are
      // in the argument collection;
      c.removeAll(cc);
      print(c);

  }
}
