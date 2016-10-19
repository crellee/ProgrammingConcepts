/**
 * Created by christianhasselstrom on 19/05/2016.
 */
public class Main
{
    public static void main (String[] args)
    {
        System.out.println(trekant(6));
    }

    public static void nedtaelling(int tal)
    {
        System.out.println(tal);
        if(tal > 1)
        {
            nedtaelling(tal - 1);
        }

    }

    public static int trekantTal(int num)
    {
        if(num == 1)
        {
            return 1;
        }
        else
        {
            return (num + trekantTal(num -1));
        }
    }
    public static int trekant (int num)
    {
        int returnnum = 0;
        for (int i = 0; i < num; i++)
        {
            returnnum = returnnum + i;
        }
        return returnnum;
    }
}
