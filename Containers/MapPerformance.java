package cyc.Containers;

import java.util.*;

public class MapPerformance {
    static List<Test<Map<Integer,Integer>>>tests=
            new ArrayList<>();
    static List<Test<SlowMap<Integer,Integer>>>slowTests=
            new ArrayList<>();
    // Tests for normal map
    static
    {
        tests.add(new Test<Map<Integer, Integer>>("put") {
            @Override
            int test(Map<Integer, Integer> container, TestParam tp) {
                int loops= tp.loops;
                int size=tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    for(int j=0;j<size;j++)
                        container.put(j, j);
                }
                return loops*size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("get") {
            @Override
            int test(Map<Integer, Integer> container, TestParam tp) {
                int loops=tp.loops;
                int span=tp.size;
                for(int i=0;i<loops;i++)
                    for(int j=0;j<span;j++)
                        container.get(j);
                return loops*span;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            @Override
            int test(Map<Integer, Integer> container, TestParam tp) {
                int loops=tp.loops;
                for(int i=0;i<loops;i++)
                {
                    Iterator it=container.entrySet().iterator();
                    while(it.hasNext())
                        it.next();
                }
                return loops*container.size();
            }
        });
    }
    // Tests for SlowMap
    static
    {
        slowTests.add(new Test<SlowMap<Integer, Integer>>("put") {
            @Override
            int test(SlowMap<Integer, Integer> container, TestParam tp) {
                int loops= tp.loops;
                int size=tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    for(int j=0;j<size;j++)
                        container.put(j, j);
                }
                return loops*size;
            }
        });
        slowTests.add(new Test<SlowMap<Integer, Integer>>("get") {
            @Override
            int test(SlowMap<Integer, Integer> container, TestParam tp) {
                int loops=tp.loops;
                int span=tp.size;
                for(int i=0;i<loops;i++)
                    for(int j=0;j<span;j++)
                        container.get(j);
                return loops*span;
            }
        });
        slowTests.add(new Test<SlowMap<Integer, Integer>>("iterate") {
            @Override
            int test(SlowMap<Integer, Integer> container, TestParam tp) {
                int loops=tp.loops;
                for(int i=0;i<loops;i++)
                {
                    Iterator it=container.entrySet().iterator();
                    while(it.hasNext())
                        it.next();
                }
                return loops*container.size();
            }
        });
    }
    public static void main(String[]args)
    {
        Tester.run(new TreeMap<>(),tests);
        Tester.run(new HashMap<>(), tests);
        Tester.run(new HashMap<>(100), tests);
        Tester.run(new LinkedHashMap<>(), tests);
        Tester.run(new IdentityHashMap<>(), tests);
        Tester.run(new WeakHashMap<>(), tests);
        Tester.run(new Hashtable<>(), tests);
        Tester.run(new SlowMap<>(), slowTests);
    }
}
