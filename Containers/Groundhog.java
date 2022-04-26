package cyc.Containers;

public class Groundhog {
    protected int number;
    public Groundhog(int num){number=num;}
    public String toString()
    {
        return "Groundhog #"+number;
    }
    public int hashCode()
    {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode()==this.hashCode();
    }
}
