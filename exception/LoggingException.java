package cyc.exception;
import java.util.logging.*;
import java.io.*;

class LoggingExc extends Exception
{
    private static Logger logger=Logger.getLogger("LoggerExc");
    public LoggingExc()
    {
        StringWriter trace =new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
public class LoggingException {
public static void main(String[]args)
{
    try
    {
        throw new LoggingExc();
    }
    catch(LoggingExc e)
    {
        System.err.println("Caught"+e);
    }

    try
    {
        throw new LoggingExc();
    }
    catch(LoggingExc e)
    {
        System.err.println("Caught"+e);
    }
}
}
