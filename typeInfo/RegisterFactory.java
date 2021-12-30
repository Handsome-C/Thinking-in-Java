package cyc.typeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  Factory<T>返回一个T对象
 * */
interface Factory<T>
{
    T create();
}
class Part
{
    public String toString()
    {
        return getClass().getSimpleName();
    }
    static List<Factory<?extends Part>> partFactories =new ArrayList<Factory<? extends Part>>();
    static{
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
    }
    private static Random rand=new Random(47);
    public static Part createRandom()
    {
        int n= rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}
class Filter extends Part {}

class FuelFilter extends  Filter
{
    public static class Factory implements cyc.typeInfo.Factory
    {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter
{
    public static class Factory implements cyc.typeInfo.Factory
    {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
public class RegisterFactory {

    static public void main(String[]args)
    {
       System.out.println(Part.createRandom());
    }
}
