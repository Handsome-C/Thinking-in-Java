package cyc.Arrays;

public class Exe_1 {
    public static void func(BerylliumSphere[] b)
    {
        System.out.println(b.length);
    }
    public static void main(String[]args)
    {
        func(new BerylliumSphere[5]);
        func(new BerylliumSphere[]{new BerylliumSphere()});
        BerylliumSphere[]b;
    }
}
