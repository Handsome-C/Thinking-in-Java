package cyc.Arrays;

import javax.annotation.Generated;
import java.util.Arrays;

public class exercise11_17 {

    public static void main(String[]args)
    {
        /**Exercise11*/
        Integer[]integers;
        int []ints=new int[10];
        //integers=ints;
        /**Exercise12*/
        double[] doubles={4,3,2,1};
        System.out.println(Arrays.toString(doubles));
        CountingGenerator.Double dGen=new CountingGenerator.Double();
        for(int i=0;i< doubles.length;i++)
            doubles[i]=dGen.next();
        System.out.println(Arrays.toString(doubles));
        /**Exercise13*/
        String string=new String();
        char[]chars=new char[10];
        CountingGenerator.Character cGen=new CountingGenerator.Character();
        for(int i=0;i<10;i++)
        {
            chars[i]=cGen.next();
        }
        string+=new String(chars);
        System.out.println(string);
        /**Exercise14 is similar to 12 and 13 ,omits it*/
        /**Exercise15,omits*/
        //TODO
    }

}
