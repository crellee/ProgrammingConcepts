/**
 * Created by christianhasselstrom on 03/06/2016.
 */
public interface Subject
{
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObs();
}
