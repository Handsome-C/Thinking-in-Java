package cyc.Containers;

import java.util.ArrayList;
import java.util.List;

public class CollectionData<T>extends ArrayList<T> {
   private CollectionData(Generator<T>gen,int num)
   {
       for(int i=0;i<num;i++)
       {
           add(gen.next());
       }
   }
   public static<T> List<T> list(Generator<T>gen, int num)
   {
       return new CollectionData<>(gen,num);
   }
}
