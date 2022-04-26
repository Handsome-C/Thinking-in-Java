package cyc.Containers;

import java.util.ArrayList;
import java.util.List;

class TestDemo extends Test<List>
{
    public TestDemo(String name)
    {
        super(name);
    }
    @Override
    int test(List container, TestParam tp) {
        for(int i=0;i< tp.loops;i++)
            container.add(i);
        return tp.loops;
    }
}
public class DoTest {
    public static void main(String[]args)
    {
        List<Test<List>>tests=new ArrayList<>();
        tests.add(new TestDemo("testDemo"));
        Tester.run(new ArrayList(), tests);
    }
}
