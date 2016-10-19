import java.util.ArrayList;
import java.util.List;

/**
 * Created by christianhasselstrom on 22/05/2016.
 */
public class BigONotation
{
    private int array[];
    private int arraySize;
    private int itemsInArray = 0;
    static long startTime;
    static long endTime;

    public static void main(String[] args)
    {
        BigONotation bigONotation4 = new BigONotation(40000000);
        bigONotation4.generateRandomArray();

        startTime = System.currentTimeMillis();
        radixsort(bigONotation4.array);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    //O(1)
    //Kører samme hastighed ligemeget hvor stor mængden af data er.
    //Ligemeget hvor stort vores array er så tager det samme tid at udføre metoden
    //Tager altid den samme tid ligemeget størrelse

    public void addIntToArray(int newInt)
    {
        array[itemsInArray++] = newInt;
    }




    //O(N^2) (1 item -> 1 second, 10 items -> 100 seconds, 100 -> 10000 seconds)
    //nærmest altid noget møg at bruge

    public void bubbleSort()
    {
        startTime = System.currentTimeMillis();

        for(int i = arraySize - 1; i > 1; i--)
        {
            for(int j = 0; j < i; j++)
            {
                if (array[j] > array[j + 1])
                {
                    swapValues(j, j+1);
                }
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " millisekunder");
    }


    public void generateRandomArray()
    {
        for(int i =0; i < arraySize; i++)
        {
            array[i] = (int) (Math.random() * 1000) + 10;
        }
        itemsInArray = arraySize - 1;
    }

    public void swapValues(int indexOne, int indexTwo)
    {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    BigONotation(int size)
    {
        arraySize = size;

        array = new int[size];
    }

    public static void radixsort(int[] input) {
        final int RADIX = 10;
        // erklærer og initialisere vores array af buckets[]
        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++)
        {
            bucket[i] = new ArrayList<Integer>();
        }

        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            // Splitter inputtet mellem listerne
            for (Integer i : input)
            {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0)
                {
                    maxLength = false;
                }
            }
            // tømmer listerne ind i input arrayet
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            // Flytter til næste cifre
            placement *= RADIX;
        }
    }

}
