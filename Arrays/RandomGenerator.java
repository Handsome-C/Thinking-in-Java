package cyc.Arrays;

import java.util.Random;

public class RandomGenerator {
    static Random r=new Random(47);

    public static class RandomCharacter
                implements Generator<java.lang.Character>
    {
        public RandomCharacter()
        {}
        @Override
        public Character next() {
            return CountingGenerator.chars[r.nextInt(CountingGenerator.chars.length)];
        }
    }
    public static class RandomString
        extends CountingGenerator.String
    {
        int length=7;
        {
            cg = new RandomCharacter();
        }

        @Override
        public String next() {
            char[]chars=new char[length];
            for(int i=0;i<length;i++)
            {
                chars[i]= cg.next();
            }
            return new String(chars);
        }
    }
}
