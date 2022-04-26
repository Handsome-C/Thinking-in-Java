package cyc.Enum;

import cyc.UtilsPackage.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static cyc.Utils.*;
enum Explore{HERE,THERE}
public class Reflection {
    public static Set<String>analyze(Class<?>enumClass)
    {
        print("---- Analyze "+enumClass+" -----");
        print("Interface");
        for(Type t: enumClass.getGenericInterfaces())
            print(t);
        print("Base: "+enumClass.getSuperclass());
        print("Methods:");
        Set<String>methods=new TreeSet<>();
        for(Method m:enumClass.getMethods())
                methods.add(m.getName());
        print(methods);
        return methods;
    }
    public static void main(String[]args)
    {
        Set<String>exploreMethods =analyze(Explore.class);
        Set<String>enumMethods=analyze(Enum.class);
        print("Explore.containAll (Enum)? "+
                exploreMethods.containsAll(enumMethods));
        printnb("Explore.removeAll(enum):");
        exploreMethods.removeAll(enumMethods);
        print(exploreMethods);
        OSExecute.command("javap D:\\Java_pro\\src\\out\\production\\src\\cyc\\Enum\\Explore.class");
    }
}
