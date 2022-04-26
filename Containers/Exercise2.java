package cyc.Containers;

import java.util.HashMap;
import java.util.Map;

public class Exercise2 {
    public static void main(String []args)
    {
        String[][]data=Country.DATA;
        Map<String,String>map=new HashMap<>();
        for(int i=0;i< data.length;i++)
        {
            if(data[i][0].matches("A\\w+"))
                map.put(data[i][0],data[i][1]);
        }
        System.out.println(map);
    }
}
