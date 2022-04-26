package cyc.Arrays;

import java.util.*;

public class ArrayGeneric {
    public static void main(String[]args)
    {
        List<String>[]ls;
        List[]la=new List[10];
        ls=(List<String>[])la;
        ls[0]=new ArrayList<>(10);
        //ls[1]=new ArrayList<Integer>(10)
        List<BerylliumSphere>[]spheres=(List<BerylliumSphere>[]) new List[10];

    }
}
