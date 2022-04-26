package cyc.Containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise40 implements Comparable<Exercise40> {
    String key;
    String value;
   public Exercise40(String key,String value)
   {
       this.key=key;
       this.value=value;
   }
    @Override
    public int compareTo(Exercise40 o) {
        return key.compareTo(o.key);
    }

    @Override
    public String toString() {
        return "key='" + key + '\'' +
                ", value='" + value + '\'';
    }
  static class comparator implements Comparator<Exercise40>
  {

      @Override
      public int compare(Exercise40 o1, Exercise40 o2) {
          return -o1.key.compareTo(o2.key);
      }
  }
    public static void main(String[]args)
    {
        List<Exercise40>strings=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            strings.add(new Exercise40(Integer.toString(10-i), Integer.toString(i)));
        }
        System.out.println(strings);
        Collections.sort(strings);
        System.out.println(strings);
        Collections.sort(strings,new comparator());
        System.out.println(strings);
    }
}
