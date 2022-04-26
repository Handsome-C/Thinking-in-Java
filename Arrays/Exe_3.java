package cyc.Arrays;

import java.util.Arrays;
import java.util.Random;

public class Exe_3 {
    static Random r=new Random(47);
    static Double[][]create(int x,int y)
    {
        Double[][]results=new Double[x][y];
        for(int i=0;i<x;i++)
            for(int j=0;j<y;j++)
                results[i][j]=r.nextDouble()*(y-x)+x;
        return results;
    }
    static void print(Double[][]res)
    {
        System.out.println(Arrays.deepToString(res));
    }
    public static void main(String[]args)
    {
        //print(create(2,5));
        int [][][]a=new int[5][6][6];
        System.out.println(Arrays.deepToString(a));
    }
}
