package cyc.Containers;

import cyc.Arrays.RandomGenerator;

import java.util.*;

public class SetPerformance {
    static List<Test<Set<Integer>>>tests=
            new ArrayList<>();
    static List<Test<Set<String>>>sTests=
            new ArrayList<>();
    static{
        tests.add(new Test<Set<Integer>>("add") {
            @Override
            int test(Set<Integer> container, TestParam tp) {
                int loops= tp.loops;
                int size= tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    for(int j=0;j<size;j++)
                      container.add(j);
                }
                return size*loops;
            }
        });
        tests.add(new Test<Set<Integer>>("contains") {
            @Override
            int test(Set<Integer> container, TestParam tp)
            {
                int loops=tp.loops;
                int size=tp.size;
                for(int i=0;i<loops;i++)
                    for(int j=0;j<size;j++)
                        container.contains(j);
                return size*loops;
            }
        });
        tests.add(new Test<Set<Integer>>("iterate") {
            @Override
            int test(Set<Integer> container, TestParam tp) {
                int loops=tp.loops*10;
                for(int i=0;i<loops;i++)
                {
                    Iterator<Integer>it =container.iterator();
                    while(it.hasNext())
                        it.next();
                }
                return loops*container.size();
            }
        });
    }
    static{
        sTests.add(new Test<Set<String>>("add") {
            @Override
            int test(Set<String> container, TestParam tp) {
                int loops= tp.loops;
                int size= tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    for(int j=0;j<size;j++)
                        container.add(new RandomGenerator.RandomString().next());
                }
                return size*loops;
            }
        });
        sTests.add(new Test<Set<String>>("contain") {
            @Override
            int test(Set<String> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for(int i=0;i<loops;i++)
                    for(int j=0;j<size;j++)
                        container.contains(new RandomGenerator.RandomString().next());
                return size*loops;
            }
        });
        sTests.add(new Test<Set<String>>("iterate") {
            @Override
            int test(Set<String> container, TestParam tp) {
                int loops=tp.loops*10;
                for(int i=0;i<loops;i++)
                {
                    Iterator<String>it =container.iterator();
                    while(it.hasNext())
                        it.next();
                }
                return loops*container.size();
            }
        });
    }
    static  public void main(String[]args)
    {
        Tester.fieldWidth=10;
       // Tester.run(new TreeSet<Integer>(), tests);
       // Tester.run(new HashSet<Integer>(), tests);
       // Tester.run(new LinkedHashSet<>(), tests);
    Tester.run(new TreeSet<String>(), sTests);
    Tester.run(new HashSet<String>(), sTests);
    Tester.run(new LinkedHashSet<String>(),sTests);

    }
}
