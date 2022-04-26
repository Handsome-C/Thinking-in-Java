package cyc.Arrays;

public class ConvertTo {
    static double[] convert(Double[]doubles)
    {
        double[] result=new double[doubles.length];
        for (int i=0;i< doubles.length;i++
             ) {
            result[i]=doubles[i];
        }
        return result;
    }
}
