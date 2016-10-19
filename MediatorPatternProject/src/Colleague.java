/**
 * Created by christianhasselstrom on 04/06/2016.
 */
public abstract class Colleague
{
    Mediator mediator;

    private int colleagueNo;

    public Colleague(Mediator newMediator)
    {
        mediator = newMediator;
        mediator.addColleague(this);
    }

    public void saleOffer(String appartmentDesc, String dateTo, int price)
    {
        mediator.saleOffer(appartmentDesc, dateTo, price, this.colleagueNo);
    }

    public void buyOffer(String appartmentDesc, String dateTo, int price)
    {
        mediator.buyOffer(appartmentDesc, dateTo, price, this.colleagueNo);
    }

    public void setColleagueNo(int colleagueNo)
    {
        this.colleagueNo = colleagueNo;
    }

}
