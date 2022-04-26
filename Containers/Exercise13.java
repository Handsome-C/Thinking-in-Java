package cyc.Containers;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise13 {
    public static void main(String[]args)
    {
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
        System.out.println(arrayList);
        AssociativeArray<String,Integer>associativeArray=new AssociativeArray<>(arrayList.size());

        //
    }
}
