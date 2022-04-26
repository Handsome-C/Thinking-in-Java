package cyc.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise_21 {
    static class BerylliumCom
                    implements Comparator<BerylliumSphere>
    {
        @Override
        public int compare(BerylliumSphere o1,BerylliumSphere o2) {
            return (o1.getId()>o2.getId()? -1:(o1.getId()== o2.getId()? 0: 1));
        }
    }
    public static void main(String[]args)
    {
        BerylliumSphere [] berylliumSpheres={new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        System.out.println(Arrays.toString(berylliumSpheres));
        Arrays.sort(berylliumSpheres,new BerylliumCom());
        System.out.println(Arrays.toString(berylliumSpheres));
    }
}
