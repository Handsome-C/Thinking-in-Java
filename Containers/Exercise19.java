package cyc.Containers;

import cyc.Arrays.CountingGenerator;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class Exercise19 {
    public static void main(String[]args) throws IOException {
        File file=new File("C:\\Users\\10204933\\Desktop\\Vb.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line;
        LinkedList<String>words=new LinkedList<>();
        while((line=bufferedReader.readLine())!=null)
        {
            Collections.addAll(words, line.split("\\W+"));
        }
        //SimpleHashMap<String,Integer>simpleHashMap=new SimpleHashMap<>();

        /**
         * SimpleHashMap2 will report the cris.
         * */
        Exercise20.SimpleHashMap2<String,Integer>simpleHashMap=new Exercise20.SimpleHashMap2<>();
        for(String s:words)
        {
            Integer value=simpleHashMap.get(s);
            simpleHashMap.put(s, value==null?1:value+1);
        }
        System.out.println(simpleHashMap);
    }
}
