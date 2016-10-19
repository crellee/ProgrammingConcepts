package SET;

import java.util.*;

/**
 * Created by christianhasselstrom on 15/05/2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        Set<Integer> hSet = new HashSet();

        int array[] =
                {
                        10, 20, 15, 5, 30, 80, 11, 99, 10
                };

        for (int i = 0; i < array.length; i++)
        {
            hSet.add(array[i]);
        }
        System.out.println("HashSet: " + hSet);

        Set<Integer> tSet = new TreeSet(hSet);
        System.out.println("TreeSet: " + tSet);

    }
}
