package cyc.exception;

public class WhoCalled {
    static void f()
    {
        try
        {
            throw new Exception();
        }
        catch(Exception e)
        {
            for (StackTraceElement s:e.getStackTrace()
                 ) {
                System.out.println(s.getMethodName());
            }
        }
    }
    static void g()
    {
        f();
    }
    static void m()
    {
        g();
    }
    static public void main(String[]args)
    {
        m();
    }
}
