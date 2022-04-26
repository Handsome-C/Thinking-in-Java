package cyc.exception;
import java.util.*;
public class Exe1 {
    static public void main(String[]args)
    {
        try
        {
            throw new Exception("Hello World");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());

        }
        finally {
            System.out.println("Execute");
        }
    }
}
