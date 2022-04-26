package cyc.Arrays;

public class GeneratorTest {
    public static void test(Class<?>surroundingClass)
    {
        for (Class<?> gen:surroundingClass.getClasses()
             ) {
            System.out.print(gen.getSimpleName()+":");
            try
            {
                Generator<?>Gen=(Generator<?>) gen.newInstance();
                for(int i=0;i<10;i++)
                    System.out.print(Gen.next()+" ");
                System.out.println();
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String []args)
    {
        test(CountingGenerator.class);
    }
}
