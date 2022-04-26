package cyc.exception;
class VeryImportantException extends Exception
{
    public String toString()
    {
        return "A very important exception";
    }
}
class normalException extends Exception
{
    public String toString()
    {
        return "A normal exception";
    }
}
public class LostMessage {
    void f() throws VeryImportantException
    {
        throw new VeryImportantException();
    }
    void dispose() throws normalException
    {
        throw new normalException();
    }
    public static void main(String[]args)
    {try
    {
        LostMessage l = new LostMessage();
        try {
                try
                {
                    l.f();
                }
                finally {
                    l.dispose();//In this case ,the VeryImportantException will be replaced by normalException.
                }
            }
        finally
        {
            l.f();
        }
    }
    catch (Exception e)
    {
        System.out.println(e);
    }
    }
}
