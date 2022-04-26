package cyc.exception;

public class Rethrowing {
    public static void f() throws Exception
    {
        System.out.println("originating the exception in f()");
        throw new Exception();
    }
    public static void g() throws Exception
    {
        try{
            f();
        }
        catch(Exception e)
        {
            System.out.println("Inside g(),e.printStackTrace()");
            e.printStackTrace(System.out);
           // throw (Exception) e.fillInStackTrace();
           throw e;
        }
    }
    public static void main(String[]args)
    {
        try
        {
            g();
        }
        catch(Exception e)
        {
            System.out.println("main:printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
