package cyc.Containers;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise4 {
    public static void main(String[]args)
    {
        ArrayList words=new ArrayList();
        File f = new File("C:\\Users\\10204933\\Desktop\\Vb.txt");
        try {
            FileInputStream fileInputStream=new FileInputStream(f);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line=new String();
            while((line=bufferedReader.readLine())!=null)
            {
                Collections.addAll(words, line.split(" "));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(words);
    }
}
