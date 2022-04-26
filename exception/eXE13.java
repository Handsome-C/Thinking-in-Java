package cyc.exception;

class exception1 extends Exception{}
class exception2 extends Exception{}
class exception3 extends Exception{}

class Ob
{
    void func(int i) throws exception1 ,exception2,exception3
    {
        switch (i) {
            case 1:
                throw new exception1();
            case 2:
                throw new exception2();
            case 3:
                throw new exception3();
        }
    }
}

public class eXE13 {
    public static void main(String[]args)
    {
        try
        {
            Ob o=new Ob();
            Integer i=new Integer(1);
            o.func(i);
        }
        catch (Exception e)
        {
            System.out.println("Exception");

        }
        finally {
            System.out.println("finally");
        }
    }
}
