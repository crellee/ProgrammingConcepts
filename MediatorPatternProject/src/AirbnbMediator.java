import java.util.ArrayList;

/**
 * Created by christianhasselstrom on 04/06/2016.
 */
public class AirbnbMediator implements Mediator
{
    private ArrayList<Colleague> colleagues;
    private ArrayList<AirbnbOffer> airbnbBuyOffers;
    private ArrayList<AirbnbOffer> airbnbSaleOffers;

    private int colleagueNo = 0;


    public AirbnbMediator()
    {
        colleagues = new ArrayList<Colleague>();
        airbnbBuyOffers = new ArrayList<AirbnbOffer>();
        airbnbSaleOffers = new ArrayList<AirbnbOffer>();
    }

    @Override
    public void saleOffer(String appartmentDesc, String dateTo, int appartmentPrice, int colleagueNo)
    {
        boolean appartmentSold = false;

        for(AirbnbOffer offer: airbnbBuyOffers)
        {

            if((offer.getAppartmentDesc() == appartmentDesc) && (offer.getAppartmentPrice() == appartmentPrice))
            {

                System.out.println(appartmentDesc +  " blev lejet for " + appartmentPrice + "kr. af " + offer.getColleagueNo());

                airbnbBuyOffers.remove(offer);

                appartmentSold = true;

            }

            if(appartmentSold)
            {
                break;
            }

        }

        if(!appartmentSold)
        {

            System.out.println(appartmentDesc + " blev tilføjet til listen med tilgængelige lejligheder");

            AirbnbOffer newAppartment = new AirbnbOffer(appartmentPrice, appartmentDesc, dateTo, colleagueNo);
            airbnbSaleOffers.add(newAppartment);

        }

    }

    @Override
    public void buyOffer(String appartmentDesc, String dateTo, int appartmentPrice, int colleagueNo)
    {
        boolean appartmentRent = false;

        for(AirbnbOffer offer: airbnbSaleOffers)
        {

            if((offer.getAppartmentDesc() == appartmentDesc) && (offer.getAppartmentPrice() == appartmentPrice))
            {

                System.out.println(appartmentDesc +  " blev udlejet for " + appartmentPrice + "kr. af " + offer.getColleagueNo());

                airbnbSaleOffers.remove(offer);

                appartmentRent = true;

            }

            if(appartmentRent)
            {
                break;
            }

        }

        if(!appartmentRent)
        {

            System.out.println(appartmentDesc + " blev tilføjet til listen med ønskede lejligheder af " + colleagueNo);

            AirbnbOffer newAppartment = new AirbnbOffer(appartmentPrice, appartmentDesc, dateTo, colleagueNo);
            airbnbBuyOffers.add(newAppartment);

        }
    }

    @Override
    public void addColleague(Colleague colleague)
    {

        colleagues.add(colleague);

        colleagueNo++;

        colleague.setColleagueNo(colleagueNo);

    }

    public void getAvaiAppart()
    {
        System.out.println("Lejligheder til udlejning: ");

        for(AirbnbOffer offer : airbnbSaleOffers)
        {
            System.out.println(offer.getAppartmentDesc() + " som koster " + offer.getAppartmentPrice() +
                    " som udlejes af: " + offer.getColleagueNo());
        }

        System.out.println("Lejligheder som ønskes");
        for(AirbnbOffer offer : airbnbBuyOffers)
        {
            System.out.println(offer.getAppartmentDesc() + " som koster " + offer.getAppartmentPrice() +
                    "som ønskes af: " + offer.getColleagueNo());
        }
    }
}
