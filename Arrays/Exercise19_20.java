package cyc.Arrays;

import java.util.Arrays;

public class Exercise19_20 {
    static class Sample
    {
        private int field;
        public Sample(int field)
        {
            this.field=field;
        }

        @Override
        public boolean equals(Object obj) {
            return field==((Sample)obj).field;
        }
    }
    public static void main(String[]args)
    {
        Sample[]samples=new Sample[10];
        Sample[]samples1=new Sample[10];
        Arrays.fill(samples,new Sample(12));
        Arrays.fill(samples1,new Sample(12));
        System.out.println(Arrays.equals(samples,samples1));
        Sample[][]samples2=new Sample[10][];
        Sample[][]samples3=new Sample[10][];
        Arrays.fill(samples2,samples);
        Arrays.fill(samples3,samples1);
        System.out.println(Arrays.deepEquals(samples2,samples3));
    }
}
