package cyc.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class CopyingBerylliumSphere {
    public static void main(String[]args)
    {
        BerylliumSphere[]olds=new BerylliumSphere[10];
        BerylliumSphere[]news=new BerylliumSphere[10];
        Arrays.fill(olds,new BerylliumSphere());
        System.out.println(Arrays.toString(olds));
        System.arraycopy(olds,0,news,0,olds.length);
        System.out.println(Arrays.toString(news));
        System.out.println(Arrays.toString(olds));
        Arrays.sort(olds, new Comparator<BerylliumSphere>() {
            @Override
            public int compare(BerylliumSphere o1, BerylliumSphere o2) {
                return 0;
            }
        });
    }
}
