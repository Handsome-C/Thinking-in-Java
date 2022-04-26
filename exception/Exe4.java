package cyc.exception;
import java.util.*;

class Exception4 extends Exception
{
  String s;
  Exception4(String s)
  {
      this.s=s;
  }
  public String toString()
  {
      return s;
  }
}

public class Exe4 {
    static public void main(String[]args)
    {
        try
        {
            throw new Exception4("Exception4");
        }
        catch(Exception4 e)
        {
            System.out.println(e);
        }
    }
}
