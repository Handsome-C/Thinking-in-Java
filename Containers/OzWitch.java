package cyc.Containers;

public  enum OzWitch {
    // Instance must be defined first,before the methods
    WEST("Miss Gulch.aka the Wicked Witch of the West"),
    NORTH("Glinda ,the Good Witch of the North");
    private String description;
    private OzWitch(String description)
    {
        this.description=description;
    }
    public String getDescription()
    {
        return description;
    }
    public static void main(String[]args)
    {
        for(OzWitch oz:OzWitch.values())
        {
            System.out.println(oz+":"+oz.getDescription());
        }
    }
}
