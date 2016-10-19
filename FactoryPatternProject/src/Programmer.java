/**
 * Created by christianhasselstrom on 21/05/2016.
 */
public abstract class Programmer
{
    private String name;
    private String favPattern;


    public String getFavPattern()
    {
        return favPattern;
    }

    public void setFavPattern(String newFavPattern)
    {
        favPattern = newFavPattern;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String newName)
    {
        name = newName;
    }

    public void displayGuy()
    {
        System.out.println(getName() + " favorit pattern er " + getFavPattern());
    }
}
