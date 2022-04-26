package cyc.exception;
class newExc extends Exception{}
class newExc2 extends Exception{}

public class Exe10 {
    static void g() throws newExc
    {
        throw new newExc();
    }

    static void f()throws newExc2
    {
        try{
            g();
        }
        catch(newExc e)
        {
            newExc2 e2=
                    new newExc2();
            e2.initCause(e.initCause(new NullPointerException()));
            throw e2;
        }
    }

    public static void main(String args[])
    {
        try
        {
            f();
        }
        catch(newExc2 e)
        {
            e.printStackTrace(System.out);
        }    }
}
