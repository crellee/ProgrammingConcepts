/**
 * Created by christianhasselstrom on 02/06/2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        Programmer programmer1 = new JavaGuy("Cyper-Lord", "Java" , "Soccer");
        programmerCheck(programmer1);
        Programmer programmer2 = new JavaGuy("Javadude", "Java", "MMA");
        programmerCheck(programmer2);
        Programmer programmer3 = new HTMLGuy("Webdude" , "HTML");
        programmerCheck(programmer3);

        Programmer programmer = new JavaGuy();
        programmer.takeBreak();
        programmer = new Programmer();
        programmer.takeBreak();
    }

    public static void programmerCheck(Programmer someProgrammer)
    {
        System.out.println(someProgrammer.getNickName() + " Likes programming");
        someProgrammer.goProgramming();

        if(someProgrammer instanceof JavaGuy)
        {
            JavaGuy tempGuy = (JavaGuy) someProgrammer;
            tempGuy.findFavHobby();
            tempGuy.takeBreak(20); // <- STATIC POLYMORPHISM

        }
        else
        {
            someProgrammer.takeBreak(); // <- STATIC POLYMORPHISM!!
        }

    }
}
