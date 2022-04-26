package cyc.Containers;

public abstract class Test<C> {
    String name;
    public Test(String name){this.name=name;}
    // return the operation numbers in the method.
    abstract int test(C container,TestParam tp);
}
