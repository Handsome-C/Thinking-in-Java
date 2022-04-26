package cyc.exception;

class ExceptionClass
{
    void func() throws SimpleException
    {
        throw new SimpleException();
    }
}

public class Exe8 {
    public static void main(String[] args)
    {
        ExceptionClass e=new ExceptionClass();
        try
        {
        e.func();
        }
        catch(SimpleException ee)
        {

        }
    }
}
