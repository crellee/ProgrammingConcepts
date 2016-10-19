import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by christianhasselstrom on 22/05/2016.
 */
public class Main
{
    public static void main(String[] args)
    {

        /*Thread timeAndDate = new Time();

        Runnable getNextEpisode1 = new GoT(5);
        Runnable getNextEpisode2 = new GoT(10);

        timeAndDate.start();


        new Thread(getNextEpisode1).start();
        new Thread(getNextEpisode2).start();
        */

        pool();

    }

    public static void pool()
    {
        ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(5);
        threadPool.scheduleAtFixedRate(new Time(), 0, 1, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(new Checker("Vikings"), 4, 10, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(new Checker("Game of thrones"), 6, 10, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(new Checker("Better call Saul"), 8, 10, TimeUnit.SECONDS);

    }

}
