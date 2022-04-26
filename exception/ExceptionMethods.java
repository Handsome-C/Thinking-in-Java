package cyc.exception;

public class ExceptionMethods {
    public static void main(String[]args)
    {
        try
        {
            throw new Exception("hello world");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
