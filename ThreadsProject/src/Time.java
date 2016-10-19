import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by christianhasselstrom on 22/05/2016.
 */
public class Time implements Runnable
{
    public void run() //<- al koden som thread eksekverer skal være i run metoden, eller i en metode som bliver kaldt fra run
    {
        Date now;
        Locale dk;
        DateFormat timeFormatter;
        String timeOutput;

        for (int i = 0; i < 10; i++)
        {
            now = new Date();
            dk = new Locale("DK");
            timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, dk);

            timeOutput = timeFormatter.format(now);

            System.out.println((i +1) + "Klokken er: " + timeOutput);

            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {

            }
        }
    }
}
