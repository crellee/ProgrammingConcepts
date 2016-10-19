import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by christianhasselstrom on 05/06/2016.
 */
public class IPFinder
{
    public static void main(String[] args)
    {
        String host;
        Scanner input = new Scanner(System.in);
        InetAddress address;
        System.out.print("\n\nEnter host name: ");
        host = input.next();
        try
        {
            address = InetAddress.getByName(host);
            System.out.println("IP address: "
                    + address.toString());
        }
        catch (UnknownHostException uhEx)
        {
            System.out.println("Could not find " + host); }
    } }
