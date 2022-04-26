package cyc.Arrays;

import java.util.Arrays;
import java.util.Random;

public class IceCream {
    private static Random r=new Random(47);
    private static final String[] FLAVORS={
            "Chocolate","Strawberry","Vanilla Fudge Swirl",
            "Mint Chip","Mocha Almond Fudge","Rum Raisin",
            "Praline Cream","Mud Pie"
    };
    static String[]getFLAVORS(int n)
    {
        String results[]=new String[n];
        boolean picked[]=new boolean[FLAVORS.length];
        for(int i=0;i<n;i++)
        {
            int t;
            do {
                t=r.nextInt(n);
            }while (picked[t]);
            picked[t]=true;
            results[i]=FLAVORS[t];
        }
        return results;
    }
    public static void main(String[]args)
    {
        System.out.println(Arrays.toString(getFLAVORS(3)));
    }
}
