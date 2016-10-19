/**
 * Created by christianhasselstrom on 04/06/2016.
 */
public interface Mediator
{
    public void saleOffer(String appartmentDesc, String dateTo, int appartmentPrice, int colleagueNo);

    public void buyOffer(String appartmentDesc, String dateTo, int appartmentPrice, int colleagueNo);

    public void addColleague(Colleague colleague);
}
