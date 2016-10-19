import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by christianhasselstrom on 05/06/2016.
 */
public class MyLocalIPAdress
{

    public static void main(String[] args)
    {
        try
        {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
        }
        catch (UnknownHostException uhEx)
                {
                System.out.println("Could not find local address!");
                }
    }
}
