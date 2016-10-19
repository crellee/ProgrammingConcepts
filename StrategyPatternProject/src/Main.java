/**
 * Created by christianhasselstrom on 25/05/2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        Programmer hans = new JavaGuy();
        Programmer chris = new HTMLGuy();

        hans.setName("Hans");
        chris.setName("Chris");

        System.out.println("Java guy: " + hans.getName() + " " + hans.tryCss());
        System.out.println("HTML guy: " + chris.getName() + " " + chris.tryCss());

        //Dynamisk skifte
        hans.setCssType(new CanCss());
        System.out.println("\nJava guy: " + hans.getName() + " " + hans.tryCss());
    }
}

