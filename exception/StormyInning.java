package cyc.exception;
class BaseballException extends Exception
{}
class Foul extends BaseballException
{}
class Strike extends  BaseballException
{}
abstract class Inning
{
    public Inning()throws BaseballException
    {}
    public void event()throws BaseballException
    {}
    public abstract void atBat() throws Strike,Foul;
    public void walk()
    {}
}
class StormException extends Exception
{}
class RainedOut extends StormException
{}
class PopFoul extends Foul
{}
interface Storm
{
    public void event() throws RainedOut;
    public void rainHard()throws RainedOut;
}
public class StormyInning extends Inning implements Storm{
    public StormyInning() throws RainedOut,BaseballException
    {}
    public void walk()
    {}
    public void event()
    {}
    public void rainHard() throws RainedOut
    {}
    public void atBat() throws PopFoul
    {}
    public static void main(String[]args)
    {
        try
        {
            StormyInning si=new StormyInning();
        }
        catch(PopFoul e)
        {
            System.out.println("Pop Foul");
        }
        catch(RainedOut e)
        {
            System.out.println("Rained Out");
        }
        catch(BaseballException e)
        {
            System.out.println("BaseballException");
        }


    }
}
