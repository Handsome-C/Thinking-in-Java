package cyc.Containers;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Exercise15 {
    public static void main(String[]args)
    {
        SlowMap<String,Integer>slowMap=new SlowMap<>();
        ArrayList arrayList=new ArrayList();
        File file=new File("C:\\Users\\10204933\\Desktop\\Vb.txt");
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line;
            while((line=bufferedReader.readLine())!=null)
            {
                Collections.addAll(arrayList, line.trim().split("\\W+"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i< arrayList.size();i++)
        {
            Integer num=slowMap.get(arrayList.get(i));
            slowMap.put((String)arrayList.get(i),num==null?1:num+1);
        }
        System.out.println(slowMap);
    }
}
