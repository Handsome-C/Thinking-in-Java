package cyc.exception;
import java.util.*;

public class Exe5 {
    public static void main(String []args)
    {
        Integer i = 0;
        while (i != 10) {
             try{
                 throw new Exception(i.toString());
             }
             catch (Exception e)
             {
                 System.out.println(e.getMessage());
                 i++;
             }
        }

    }
}
