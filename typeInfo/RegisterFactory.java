package cyc.typeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* 工厂接口
*/
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
    /**
    * partFactories:存储工厂对象
    */
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
    /**
    * 用内部类实现工厂.
    * 重用名字Factory的唯一方法是给出完整的名字
    * ex:cyc.typeInfo.Factory
    */
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
