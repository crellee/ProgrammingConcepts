import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Created by christianhasselstrom on 05/06/2016.
 */
public class TCPEchoClient
{
    private static InetAddress host;
    private static final int PORT = 1234;

    public static void main(String[] args)
    {
        try
        {
            host = InetAddress.getLocalHost();      //<-finder host, dvs. serverens ip-adresse
        }
        catch (UnknownHostException uhEx)
        {
            System.out.println("Host ID not found!");
            System.exit(1);
        }
        accessServer();
    }
    private static void accessServer()
    {
        Socket link = null;
        try
        {
            link = new Socket(host, PORT);                      //<- Her laver vi en ny socket, hvor vi bruger serverens
                                                                //ip-adresse, og den passende port
            Scanner input = new Scanner(link.getInputStream()); //<- getInput og getOutput er til kommunikationen
                                                                // med serveren. true for at flushe output bufferen
            PrintWriter output = new PrintWriter(link.getOutputStream() , true);
            Scanner userEntry = new Scanner(System.in);

            String message, response;
            do
            {
                System.out.print("Enter message: ");
                message = userEntry.nextLine();
                output.println(message);                        //scanner-objektet i klient-enden vil modtage beskeder
                                                                //sendt af printwriter objektet i server-enden
                response = input.nextLine();
                System.out.println("\nSERVER> "+response);
            }
            while (!message.equals("***CLOSE***"));
        }
        catch(IOException ioEx) {
            ioEx.printStackTrace();
        }
        finally
        {
            try
            {
                System.out.println("\n* Closing connection... *");
                link.close();                                       //<- lukker og slukker
            }
            catch(IOException ioEx) {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}
