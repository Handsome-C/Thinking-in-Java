package cyc.Enum;

import cyc.Containers.Generator;

import java.util.Random;

enum CartoonCharacter
implements Generator<CartoonCharacter>
{
    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
   private Random random=new Random(47);
    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T>void printNext(Generator<T>gen)
    {
        System.out.println(gen.next());
    }
    public static void main(String[]args)
    {
        CartoonCharacter cc=CartoonCharacter.BOB;
        for(int i=0;i<10;i++)
            printNext(cc);
    }
}
