package cyc.exception;
import java.util.*;
class SimpleException extends Exception
{}

public class InheritingExceptions {
void func() throws SimpleException
{
    System.out.println("Trow SimpleException from func()");
    throw new SimpleException();
}


public static void main(String[]args)
{
    InheritingExceptions e=new InheritingExceptions();
    try{
        e.func();
    }
    catch (SimpleException s)
    {
        System.out.println("Caught it!!");
    }
}

}
