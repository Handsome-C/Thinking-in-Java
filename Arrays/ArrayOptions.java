package cyc.Arrays;

import java.util.Arrays;

class BerylliumSphere
{
    private static int counter=0;
    private final int id=++counter;
    int getId()
    {
        return id;
    }
    public String toString()
    {
        return "Sphere "+id;
    }
}
public class ArrayOptions {
    public static void main(String[]args)
    {
        // Even if the refs were not  created.
        BerylliumSphere[]a;
        // The ref in the array b automatically initialized to null.
        BerylliumSphere[]b=new BerylliumSphere[5];
        System.out.println("b:"+ Arrays.toString(b));
        BerylliumSphere[]c=new BerylliumSphere[4];
        for(int i=0;i<4;i++)
        {
            if(c[i]==null)
                c[i]=new BerylliumSphere();
        }
        System.out.println("c: "+Arrays.toString(c));
        BerylliumSphere[]d={new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        a=new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()};
        System.out.println("a.length:"+a.length);
        System.out.println("b.length:"+b.length);
        System.out.println("c.length:"+c.length);
        System.out.println("d.length:"+d.length);

        int []e;
        int []f=new int[5];
        System.out.println("f: "+Arrays.toString(f));
        int[]g=new int[4];
        for(int i=0;i<4;i++)
        {
            g[i]=i*i;
        }
        System.out.println("g: "+Arrays.toString(g));
    }
}
