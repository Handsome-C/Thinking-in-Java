package cyc.Containers;

import cyc.Arrays.CountingGenerator;

import java.util.*;

class StringArray extends AbstractList<String>
{

    private static int SIZE=10;
    String[]strings=new String[SIZE];
    private int index=-1;
    public void put(String s)
    {
        if(++index==SIZE)
        {
            String copy[]=strings;
            strings=new String[2*SIZE+1];
            System.arraycopy(copy,0,strings,0,copy.length);
            SIZE=2*SIZE+1;
        }
        strings[index]=s;
    }
    public void insert(String s,int it)
    {
        if(++index==SIZE)
        {
            String copy[]=strings;
            strings=new String[2*SIZE+1];
            System.arraycopy(copy,0,strings,0,copy.length);
            SIZE=2*SIZE+1;
        }
        for(int i=index-1;i>=it;i--)
        {
            strings[i+1]=strings[i];
        }
        strings[it]=s;
    }

    @Override
    public int size() {
        return index+1;
    }

    public String toString()
    {
        return Arrays.toString(strings);
    }

    @Override
    public String get(int index) {
        return strings[index];
    }
}
public class Exercise31 {

    public static void main(String[]args)
    {
        StringArray stringArray=new StringArray();
        for(int i=0;i<10;i++)
            stringArray.put(Integer.toString(i));
        System.out.println(stringArray);
        stringArray.insert("hi", 5);
        stringArray.insert("hi", 0);
        stringArray.insert("hi", 2);
        List<Test<StringArray>>tests=
                new ArrayList<>();
        tests.add(new Test<StringArray>("put") {
            @Override
            int test(StringArray container, TestParam tp) {
                int loops=tp.loops;
                //int size=tp.size;
                try {
                    for (int i = 0; i < loops; i++) {
                        container.put(Integer.toString(i));
                    }
                }
                catch (Exception E)
                {
                    System.out.println("error");
                }
                return loops;
            }
        });
        tests.add(new Test<StringArray>("insert") {
            @Override
            int test(StringArray container, TestParam tp) {
                Random random=new Random();
                for(int i=0;i<tp.loops;i++)
                   container.insert(Integer.toString(i), random.nextInt(container.size()));
                return tp.loops;
            }
        });
        List<Test<ArrayList<String>>>arrayListTests=
                new ArrayList<>();
        arrayListTests.add(new Test<ArrayList<String>>("put") {
            @Override
            int test(ArrayList<String> container, TestParam tp) {
                int loops=tp.loops;
                //int size=tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.add(Integer.toString(i));
                }
                return loops;
            }
        });
        arrayListTests.add(new Test<ArrayList<String>>("insert") {
            @Override
            int test(ArrayList<String> container, TestParam tp) {
                int loops=tp.loops;
                //int size=tp.size;
                Random r=new Random();
                for(int i=0;i<loops;i++)
                {
                    container.add(r.nextInt(container.size()),Integer.toString(i));
                }
                return loops;
            }
        });
        Tester.run(new StringArray(), tests);
        Tester.run(new ArrayList<String>(), arrayListTests);
        System.out.println(stringArray);
        /*for(int i=0;i<10;i++)
            stringArray.put(Integer.toString(i));
        System.out.println(stringArray);*/
    }

}
