package cyc.exception;
class Shape{
    public Shape(String s)
    {
        System.out.println(s+"has created");
    }
    void dispose()
    {
        System.out.println("Shape dispose");
    }
}

class Circle extends Shape{
    public Circle()
    {
        super("Circle");
    }

    void dispose()
    {
        System.out.println("Circle dispose");
    }
}

class Line extends Shape{
    public Line(int start,int end)
    {
        super("Line");
        System.out.println("Drawing line from "+start+"to" +end);
    }
    void dispose()
    {
        System.out.println("Line dispose");
    }
}


public class Exe16 {
    private Circle c;
    private Line l;
    public Exe16(int i)
    {
        l=new Line(i,i);
        c=new Circle();
    }
    public void dispose()
    {
        l.dispose();
        c.dispose();
    }
    public static void main(String[]args)
    {
        Exe16 e=new Exe16(10);
        try
        {
            return ;
        }
        finally
        {
            e.dispose();
        }
    }
}
