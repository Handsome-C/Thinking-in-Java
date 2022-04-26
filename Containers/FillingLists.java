package cyc.Containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class StringAddress
{
    private String val;
    public StringAddress(String val){this.val=val;}

    @Override
    public String toString() {
        return super.toString()+val;
    }
}
public class FillingLists {
    public static void main(String[]args)
    {
        //List<StringAddress>ls=new ArrayList<>();
        List<StringAddress> ls=new ArrayList<>(Collections.nCopies(4,new StringAddress("Hello")));
        System.out.println(ls);
        Collections.fill(ls,new StringAddress("world"));
        System.out.println(ls);

    }
}
