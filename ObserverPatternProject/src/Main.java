/**
 * Created by christianhasselstrom on 03/06/2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        IcecreamUpdate icecreamUpdate = new IcecreamUpdate();

        IcecreamObserver icecreamObserver1 = new IcecreamObserver(icecreamUpdate);

        icecreamUpdate.setFrisko(10);
        icecreamUpdate.setCartedor(15);
        icecreamUpdate.setPolar(8);

        IcecreamObserver icecreamObserver2 = new IcecreamObserver(icecreamUpdate);

        icecreamUpdate.setFrisko(6);

        icecreamUpdate.unregister(icecreamObserver1);

        IcecreamObserver icecreamObserver3 = new IcecreamObserver(icecreamUpdate);

        icecreamUpdate.setPolar(5);



    }
}
