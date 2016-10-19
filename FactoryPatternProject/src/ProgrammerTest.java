import java.util.Scanner;

/**
 * Created by christianhasselstrom on 21/05/2016.
 */
public class ProgrammerTest
{
    public static void main(String[] args)
    {
        ProgrammerFactory programmerFactory = new ProgrammerFactory();

        Programmer programmer = null;

        Scanner in = new Scanner(System.in);

        System.out.println("Hvilken type programmør (H / J / B)");

        if(in.hasNextLine())
        {
            String programmerType = in.nextLine();
            programmer = programmerFactory.createProgrammer(programmerType);
        }

        if(programmer != null)
        {
            getGuy(programmer);
        }
        else
        {
            System.out.println("Forkert bogstav. Prøv A / B / C");
        }
    }
    public static void getGuy(Programmer newProgrammer)
    {
        newProgrammer.displayGuy();
    }
}
