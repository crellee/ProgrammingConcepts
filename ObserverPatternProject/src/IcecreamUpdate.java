import java.util.ArrayList;

/**
 * Created by christianhasselstrom on 03/06/2016.
 */
public class IcecreamUpdate implements Subject
{   //bruger subject interfacet til at opdatere alle observers
    private ArrayList<Observer> observers;
    private int frisko;
    private int cartedor;
    private int polar;

    public IcecreamUpdate()
    {   //ny arraylist til at opbevare alle observers
        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer o)
    {   //tilføjer ny observer til arraylisten
        observers.add(o);
    }

    @Override
    public void unregister(Observer o)
    {
        int observerIndex = observers.indexOf(o);
        System.out.println("Observer " + (observerIndex+1) + " slettet");
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObs()
    {   //looper gennem alle observers og fortæller dem at der er blevet opdateret
        for(Observer observer : observers)
        {
            observer.update(frisko, cartedor, polar);
        }
    }
    public void setFrisko(int frisko)
    {
        this.frisko = frisko;
        notifyObs();
    }

    public void setCartedor(int cartedor)
    {
        this.cartedor = cartedor;
        notifyObs();
    }

    public void setPolar(int polar)
    {
        this.polar = polar;
        notifyObs();
    }

}
