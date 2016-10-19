/**
 * Created by christianhasselstrom on 22/05/2016.
 */
public class GoT implements Runnable
{
    private int startTime;

    public GoT(int startTime)
    {
        this.startTime = startTime;
    }

    public void run(){
        try {
            Thread.sleep(startTime * 1000);
            //
            }
        catch(InterruptedException e)
        {
        }
        System.out.println("Kigger efter ny game of thrones episode");
    }
}
