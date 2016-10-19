/**
 * Created by christianhasselstrom on 03/06/2016.
 */
public class IcecreamObserver implements Observer
{
    private int frisko;
    private int cartedor;
    private int polar;
    private static int idTracker = 0;   //statics variabel da vi bruger den til at tælle
    private int observerId;             //til at tracke observerne
    private Subject icecreamUpdate;     //Har referencen til IcecreamUpdate objektet

    public IcecreamObserver(Subject icecreamUpdate)
    {
        this.icecreamUpdate = icecreamUpdate;
        this.observerId = ++idTracker;     //observer IDet incrementeres med 1
        System.out.println("Dette er en ny observer med observer ID " + this.observerId);
        icecreamUpdate.register(this);      //tilføjer observeren til Subject's arraylist
    }

    @Override
    public void update(int frisko, int cartedor, int polar)
    {
        this.frisko = frisko;
        this.cartedor = cartedor;
        this.polar = polar;
        printIcecreamPrices();
    }

    public void printIcecreamPrices()
    {
        System.out.println("Observer id: " + observerId +
                "\nFrisko pris: " + frisko +
                "\nCartedor pris: " + cartedor +
                "\nPolar pris: " + polar + "\n" );
    }
}
