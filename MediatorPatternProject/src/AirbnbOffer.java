/**
 * Created by christianhasselstrom on 04/06/2016.
 */
public class AirbnbOffer
{
    int appartmentPrice = 0;
    String appartmentDesc = "";
    String dateTo = "";
    int colleagueNo = 0;

    public AirbnbOffer(int price, String description, String date, int no)
    {
        appartmentPrice = price;
        appartmentDesc = description;
        dateTo = date;
        colleagueNo = no;
    }

    public int getAppartmentPrice()
    {
        return appartmentPrice;
    }

    public String getAppartmentDesc()
    {
        return appartmentDesc;
    }

    public String getDateTo()
    {
        return dateTo;
    }


    public int getColleagueNo()
    {
        return colleagueNo;
    }
}
