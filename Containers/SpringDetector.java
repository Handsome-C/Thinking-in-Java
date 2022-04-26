package cyc.Containers;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import static cyc.Utils.*;
public class SpringDetector {
    public static<T extends Groundhog>
    void detectSpring(Class<T>type)throws Exception
    {
        Constructor<T>gHog=type.getConstructor(int.class);
        Map<Groundhog,Prediction>map=
                new HashMap<>();
        for(int i=0;i<10;i++)
        {
            map.put(gHog.newInstance(i),new Prediction());
        }
        print(map);
        Groundhog gh= gHog.newInstance(3);
        if(map.containsKey(gh))
            print(map.get(gh));
        else
        {
            print("Key not found: "+gh);
        }
    }
    public static void main(String[]args)
    {
        try
        {
        detectSpring(Groundhog.class);
        }
        catch (Exception e)
        {

        }
    }
}
