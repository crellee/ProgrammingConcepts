import java.lang.reflect.Array;

/**
 * Created by christianhasselstrom on 15/05/2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        AList<String> aList = new AList();

        aList.add("To do a");
        aList.add("To do b");
        aList.add("To do c");
        aList.add("To do d");
        aList.add("To do e");
        aList.add("To do f");
        aList.add(1, "Do this first");

        for(int i = 0; i < aList.getLength(); i++)
        {
            System.out.println("List at position: " + (i + 1) +  " is: " + Array.get(aList.toArray(), i));
        }
        ListInterface listInterface;
        listInterface = new AList<>(2);
        listInterface.add(32);
        listInterface.giveT(listInterface);
        System.out.println(listInterface.getLength());
        ListXInterface hej = (ListXInterface) new AList<>();

    }
}
