package cyc.Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Exercise22_24 {
    static class ReverseIntegerCom
    implements Comparator<Integer>
    {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -o1.compareTo(o2);
        }
    }
    public static void main(String[]args)
    {
        /**Exercise_22*/
        int []ints={3,5,1,9,-1,6,2};
        int location=Arrays.binarySearch(ints,3);
        System.out.println(location);
        /**Exercise_23*/
        Random r=new Random(47);
        Integer[]integers=new Integer[10];
        for(int i=0;i<10;i++)
            integers[i]= r.nextInt(1000);
        System.out.println(Arrays.toString(integers));
        Arrays.sort(integers,new ReverseIntegerCom());
        System.out.println(Arrays.toString(integers));
    }
}
