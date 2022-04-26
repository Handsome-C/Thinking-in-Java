package cyc.Arrays;
interface Generator<T>
{
    T next();
}
public class CountingGenerator {
    public static class Boolean
              implements Generator<java.lang.Boolean>
    {
        private java.lang.Boolean b=false;
        @Override
        public java.lang.Boolean next() {
            b=!b;
            return b;
        }
    }
    public static class Byte
                implements Generator<java.lang.Byte>
    {
        private byte val=0;
        @Override
        public java.lang.Byte next() {
            return val++;
        }
    }
    static char[]chars=("abcdefghijk"+"ABCDEFGHIJK").toCharArray();
    public static class Character
                        implements Generator<java.lang.Character>
    {
        private int index=0;
        @Override
        public java.lang.Character next() {
            return chars[index++% chars.length];
        }
    }

    public static class String
                implements Generator<java.lang.String>
    {
        private int length=7;
        protected Generator<java.lang.Character>cg=new Character();
        public String(){}
        public String(int length){this.length=length;}
        @Override
        public java.lang.String next() {
            char[]chars=new char[length];
            for(int i=0;i<length;i++)
                chars[i]=cg.next();
            return  new java.lang.String(chars);
        }
    }
    public static class Short
                implements Generator<java.lang.Short>
    {
        private java.lang.Short val=0;

        @Override
        public java.lang.Short next() {
            return val++;
        }
    }

    public static class Integer
                    implements Generator<java.lang.Integer>
    {
        private java.lang.Integer val=0;
        @Override
        public java.lang.Integer next() {
            return val++;
        }
    }

    public static class Long
                        implements Generator<java.lang.Long>
    {
        private long val=0;
        @Override
        public java.lang.Long next() {
            return val++;
        }
    }
    public static class Float
                    implements Generator<java.lang.Float>
    {
        private float val=0;
        @Override
        public java.lang.Float next() {
            float result=val;
            val+=1.0;
            return result;
        }
    }
    public static class Double
                    implements Generator<java.lang.Double>
    {
        private double val=0;
        @Override
        public java.lang.Double next() {
            double result=val;
            val+=1;
            return result;
        }
    }
    public static class BerylliumSphere
                     implements Generator<cyc.Arrays.BerylliumSphere>
    {
        @Override
        public cyc.Arrays.BerylliumSphere next() {
            return new cyc.Arrays.BerylliumSphere();
        }
    }

}
