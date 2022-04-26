package cyc.exception;
import java.util.logging.*;
import java.io.*;
class LogException1 extends Exception
{
    Logger logger=Logger.getLogger("LogException1");
    public LogException1()
    {
        StringWriter trace=new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

class LogException2 extends Exception
{
    Logger logger=Logger.getLogger("LogException2");
    public LogException2()
    {
        StringWriter trace =new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

}
public class Exe6 {
    public static void main(String[]args)
    {
        try{
            throw new LogException1();
        }
        catch (LogException1 e)
        {
            System.err.println("Caught "+e);
        }

        try
        {
            throw new LogException2();
        }
        catch(LogException2 e)
        {
            System.err.println("Caught "+e);
        }
    }
}
