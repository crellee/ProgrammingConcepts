package MAPS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;


/**
 * Created by christianhasselstrom on 18/05/2016.
 */
public class MapTest
{
    public static void main(String[] args)
    {
        Map<Integer, String> hMap = new HashMap();

        String array[] =
                {
                    "Hashing" , "Maps" , "Heaps"
                };

        for (int i = 0; i < array.length; i++)
        {
            hMap.put(i, array[i]);
        }

        System.out.println(hMap.keySet() + "\n" + hMap.values() + "\n" + hMap.entrySet() + "\n");

        Map tMap = new TreeMap(hMap);

        for(Iterator iter = tMap.entrySet().iterator(); iter.hasNext();)
        {
            System.out.println(iter.next());
        }
    }
}
