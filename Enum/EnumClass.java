package cyc.Enum;
import static cyc.Utils.*;
// Capabilities of the Enum Class
enum Shrubbery{GROUND,CRAWLING,HANGING}

public class EnumClass {
   public static void main(String[]args)
   {
       for(Shrubbery s:Shrubbery.values())
       {
           print(s+" ordinal: "+s.ordinal());
           printnb(s.compareTo(Shrubbery.CRAWLING)+" ");
           printnb(s.equals(Shrubbery.CRAWLING)+" ");
           print(s==Shrubbery.CRAWLING);
           print(s.getClass());
           print(s.name());
           print("-----------");
       }
       // Produce an enum value from a string name
       for(String s:"HANGING CRAWLING GROUND".split(" "))
       {
           Shrubbery shrub=Enum.valueOf(Shrubbery.class, s);
           print(shrub);
       }
       print(Shrubbery.CRAWLING);
   }
}
