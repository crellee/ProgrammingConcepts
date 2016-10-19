import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Created by christianhasselstrom on 05/06/2016.
 */
public class TCPEchoServer
{
    private static ServerSocket serverSocket;
    private static final int PORT = 1234;

    public static void main(String[] args)
    {
        System.out.println("Opening port...\n");
        try
        {
            serverSocket = new ServerSocket(PORT);      //<- laver nyt serversocket objekt
                                                        //og venter på en forbindelse fra en klient
                                                        //med på port 1234
        }
        catch(IOException ioEx)
        {
                System.out.println(
                        "Unable to attach to port!");
                System.exit(1);
        }
            do
            {
                handleClient();
            }
            while (true);
        }
    private static void handleClient()
    {
        Socket link = null;
        try
        {
            link = serverSocket.accept();                       //<- venter på klienten. Returnere et socket objekt
                                                                // når forbindelsen er lavet.
            Scanner input = new Scanner(link.getInputStream()); //<- getInput og getOutput er til kommunikationen
                                                                // med klienten. true for at flushe output bufferen
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);
            int numMessages = 0;
            String message = input.nextLine();      //med scanner og printwriter sat op, bliver der sendt og modtaget beskeder.
                                                    // nextLine for at modtage, og og prinln for at sende
            while (!message.equals("***CLOSE***"))
            {
                System.out.println("Message received: " + message);
                numMessages++;
                output.println("Message " + numMessages + ": " + message);
                message = input.nextLine();
            }
            output.println(numMessages + " messages received.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                System.out.println("\n* Closing connection... *");
                link.close();                                       //lukker og slukker
            }
            catch(IOException e)
            {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }

    }
}

