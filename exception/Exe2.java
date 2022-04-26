package cyc.exception;
import java.util.*;
public class Exe2 {
static public void main(String []args)
{
    Integer t=null ;
    int [] array={1,2};
    try
    {

        System.out.println(array[2]);
    }
    catch(ArrayIndexOutOfBoundsException  e)
    {
        System.out.println("arrayIndexOutOfBoundException");
    }
}

}
