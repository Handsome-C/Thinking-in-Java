package cyc.Enum;
// Enums in enums by interface.
import static cyc.UtilsPackage.Enums.*;
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    NEWCOURSE(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Course(Class<?extends Food> c)
    {
        values=c.getEnumConstants();
    }
    public Food randomSection()
    {
        return random(values);
    }
}
