package cyc.Containers;

public class Exercise22 {
    public static void main(String[]args)
    {
        SimpleHashMap<String,String>map=new SimpleHashMap<>();
        map.put("1", "Cyc");
        map.put("2","Tnt");
        System.out.println(map);
        map.remove("1");
        //map.clear();
        System.out.println(map);

    }
}
