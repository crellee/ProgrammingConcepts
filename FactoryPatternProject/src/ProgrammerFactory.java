/**
 * Created by christianhasselstrom on 21/05/2016.
 */
public class ProgrammerFactory
{
    public Programmer createProgrammer(String newProgrammerType)
    {
        Programmer newProgrammer = null;

        if(newProgrammerType.equals("J"))
        {
            return new JavaGuy();
        }
        else if(newProgrammerType.equals("H"))
        {
            return new HTMLGuy();
        }
        else if(newProgrammerType.equals("B"))
        {
            return new BeginnerJavaGuy();
        }
        else
        {
            return null;
        }

    }
}
