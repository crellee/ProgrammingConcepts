import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by christianhasselstrom on 22/05/2016.
 */
public class Checker implements Runnable
{
    ReentrantLock lock = new ReentrantLock();

    private String checkSeries;

    public Checker(String checkSeries)
    {
        this.checkSeries = checkSeries;
    }

    synchronized public void run()
    {
            //lock.lock();
            System.out.println("Kigger efter ny episode af: " + this.checkSeries);
            //lock.unlock();
    }
}
