package cyc.Containers;

import cyc.Arrays.CountingGenerator;
import cyc.Arrays.RandomGenerator;
import cyc.template.Generators;

import javax.swing.*;
import java.util.*;

public class ListPerformance {
    static Random random=new Random();
    static int reps=1000;
    static List<Test<List<Integer>>>tests=
            new ArrayList<>();
    static List<Test<LinkedList<Integer>>>qTests=
            new ArrayList<>();
    static List<Test<List<String>>>sTests=
            new ArrayList<>();
    static{
        // Using the unknown class.
        /**
         *  Test List<Integer>
         * */
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops= tp.loops;
                int listSize= tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    for(int j=0;j<listSize;j++)
                        container.add(j);
                }
                return loops*listSize;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops*reps;
                int size=container.size();
                for(int i=0;i<loops;i++)
                    container.get(random.nextInt(size));
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("set") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops*reps;
                int size=container.size();
                for(int i=0;i<loops;i++)
                    container.set(random.nextInt(size),47);
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("iteratorAdd") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=1000000;
                int half=container.size()/2;
                ListIterator<Integer>it= container.listIterator(half);
                for(int i=0;i<loops;i++)
                    it.add(47);
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops;
                for(int i=0;i<loops;i++)
                    container.add(5,47);
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    while(container.size()>5)
                        container.remove(5);
                }
                return loops*size;
            }
        });
        tests.add(new Test<List<Integer>>("sort") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    Collections.sort(container);
                }
                return loops;
            }
        });
        /**
         *  Test Queue
         * */
        qTests.add(new Test<LinkedList<Integer>>("addFirst") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    for(int j=0;j<size;j++)
                        container.addFirst(47);
                }
                return loops*size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("addLast") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    for(int j=0;j<size;j++)
                        container.addLast(47);
                }
                return loops*size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmFirst") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    while(container.size()>0)
                        container.removeFirst();
                }
                return loops*size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmLast") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for(int i=0;i<loops;i++)
                {
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    while(container.size()>0)
                        container.removeLast();
                }
                return loops*size;
            }
        });

    }
    static class ListTester extends Tester<List<Integer>>
    {
        public ListTester(List<Integer>container,List<Test<List<Integer>>>tests)
        {
         super(container,tests);
        }

        @Override
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }
        public static void run(List<Integer>list,List<Test<List<Integer>>>tests)
        {
            new ListTester(list, tests).timedTest();
        }
        public static void main(String[]args)
        {
            if(args.length>0)
                Tester.defaultParams=TestParam.array(args);
            Tester<List<Integer>>tester=new Tester<List<Integer>>(null, tests.subList(1,3))
            {
                @Override
                protected List<Integer> initialize(int size) {
                    return new ArrayList<Integer>(new CountingIntegerList(size));
                }
            };
            tester.setHeadline("Array as List");
            tester.timedTest();
            Tester.defaultParams=TestParam.array(10,5000,100,5000,1000,1000,10000,200);
            if(args.length>0)
                Tester.defaultParams=TestParam.array(args);
            Tester.run(new ArrayList<Integer>(), tests);
            Tester.run(new LinkedList<Integer>(),tests);
            Tester.run(new Vector<Integer>(),tests);
            Tester<LinkedList<Integer>>qTester =new Tester<>(new LinkedList<>(), qTests);
            qTester.setHeadline("Queue tests");
            qTester.timedTest();

        }
    }
}
