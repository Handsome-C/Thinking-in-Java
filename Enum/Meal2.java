package cyc.Enum;

import static cyc.UtilsPackage.Enums.random;

public enum Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Meal2(Class<?extends Food> c)
    {
        values=c.getEnumConstants();
    }
    public Food randomSection()
    {
        return random(values);
    }
    interface Food {
        enum Appetizer implements Food
        {
            SALAD,SOUP,SPRING_ROLLS;
        }
        enum MainCourse implements Food
        {
            LASAGNE,BURRITO,PAN_THAI,
            LENTILS,HUMMOUS,VINDALOO
        }
        enum Dessert implements Food
        {
            TIRANMISU,GELATO,BLACK_FOREST_CAKE,
            FRUIT,CREME_CARAMEL
        }
        enum Coffee implements Food
        {
            BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,
            LATTE,CAPPUCCINO,TEA,HERB_TEA
        }
    }
    public static void main(String[]args)
    {
        for(int i=0;i<5;i++)
        {
            for(Meal2 meal2:Meal2.values())
            {
                Food food=meal2.randomSection();
                System.out.println(food);
            }
            System.out.println("-----");
        }
    }
}
